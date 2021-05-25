package kodlamaio.hrms.business.concreates;

import java.util.regex.Pattern;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployeeConfirmsEmployerService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.adapters.ValidationService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verifications.VerificationService;
import kodlamaio.hrms.entities.concreates.Candidate;
import kodlamaio.hrms.entities.concreates.EmployeeConfirmsEmployer;
import kodlamaio.hrms.entities.concreates.Employer;
import kodlamaio.hrms.entities.concreates.VerificationCode;
import kodlamaio.hrms.entities.dtos.CandidateDto;
import kodlamaio.hrms.entities.dtos.EmployerDto;

@Service
public class AuthManager implements AuthService {

	private ModelMapper modelMapper;
	private CandidateService candidateService;
	private EmployerService employerService;
	private UserService userService;
	private ValidationService validationService;
	private VerificationService verificationService;
	private VerificationCodeService verificationCodeService;
	private EmployeeConfirmsEmployerService employeeConfirmsEmployerService;

	@Autowired
	public AuthManager(ModelMapper modelMapper, CandidateService candidateService, EmployerService employerService,
			UserService userService, ValidationService validationService, VerificationService verificationService,
			VerificationCodeService verificationCodeService,
			EmployeeConfirmsEmployerService employeeConfirmsEmployerService) {
		this.modelMapper = modelMapper;
		this.candidateService = candidateService;
		this.employerService = employerService;
		this.userService = userService;
		this.validationService = validationService;
		this.verificationService = verificationService;
		this.verificationCodeService = verificationCodeService;
		this.employeeConfirmsEmployerService = employeeConfirmsEmployerService;

	}

	@Override
	public Result registerToCandidate(CandidateDto candidateDto) {
		Candidate candidate = modelMapper.map(candidateDto, Candidate.class);

		if (!isAllFieldsFilled(candidateDto.getFirstName(), candidateDto.getLastName(),
				candidateDto.getIdentificationNumber(), candidateDto.getEmail(), candidateDto.getPassword())) {
			return new ErrorResult(Messages.allFieldsFilled);
		}

		if (!isMailFormatValid(candidateDto.getEmail())) {
			return new ErrorResult(Messages.mailFormatNotValid);
		}

		if (isEmailExists(candidateDto.getEmail())) {
			return new ErrorResult(Messages.emailExists);
		}

		if (isIdentificationNumberExists(candidateDto.getIdentificationNumber())) {
			return new ErrorResult(Messages.IdentificationNumberExists);
		}

		if (!isEqualsPasswordConfirm(candidateDto.getPassword(), candidateDto.getConfirmPassword())) {

			return new ErrorResult(Messages.passwordNotMatched);
		}

		// Fake Mernis
		if (!this.validationService.CheckIfRealPerson(candidateDto.getFirstName(), candidateDto.getLastName(),
				candidateDto.getIdentificationNumber(), candidateDto.getBirthDate().toString())) {
			return new ErrorResult(Messages.verificationError);
		}

		candidateService.add(candidate);
		// Fake Email
		verificationService.sendEmail(candidateDto.getEmail(),
				verificationCodeService.generateCode(candidate.getId()).getData());
		return new SuccessResult(Messages.registerAndVerification);
	}

	@Override
	public Result registerToEmployer(EmployerDto employerDto) {
		Employer employer = modelMapper.map(employerDto, Employer.class);

		if (!isEmailEqualsToDomain(employerDto.getEmail(), employerDto.getWebAddress())) {
			return new ErrorResult(Messages.emailEqualsToDomain);
		}

		if (isEmailExists(employerDto.getEmail())) {
			return new ErrorResult(Messages.emailExists);
		}

		this.employerService.add(employer);

		// Fake Email
		verificationService.sendEmail(employerDto.getEmail(),
				verificationCodeService.generateCode(employer.getId()).getData());

		// TODO: Employee Verify
		return new SuccessResult(Messages.registerAndVerification);
	}
	
	@Override
	public Result verifyToCandidate(String code) {
		VerificationCode verificationCode = this.verificationCodeService.findByCode(code);		
		verificationCode.setVerified(true);
		this.verificationCodeService.add(verificationCode);
		return new SuccessResult(Messages.verifiedCandidate);
	}

	@Override
	public Result verifyToEmployer(int employerId) {
		EmployeeConfirmsEmployer employeeConfirmsEmployer = this.employeeConfirmsEmployerService
				.findByEmployer(employerId);
		employeeConfirmsEmployer.setConfirmed(true);
		this.employeeConfirmsEmployerService.add(employeeConfirmsEmployer);
		return new SuccessResult(Messages.verifiedEmployer);
	}

	// Business Rules

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	private boolean isMailFormatValid(String email) {
		return VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
	}

	private boolean isEmailExists(String email) {
		return (userService.findByEmail(email).getData() != null);
	}

	private boolean isIdentificationNumberExists(String identificationNumber) {
		return (candidateService.findByIdentificationNumber(identificationNumber).getData() != null);
	}

	private boolean isEqualsPasswordConfirm(String password, String confirmPassword) {

		return (password.equals(confirmPassword));
	}

	private boolean isEmailEqualsToDomain(String email, String webAddress) {
		String[] array = email.split("@");
		return array[1].equals(webAddress);
	}

	private boolean isAllFieldsFilled(String firstName, String lastName, String identificationNumber, String email,
			String password) {
		if (firstName.length() <= 0 || lastName.length() <= 0 || email.length() <= 0 || password.length() <= 0
				|| identificationNumber.length() != 11) {
			return false;
		}
		return true;
	}	

}
