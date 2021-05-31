package kodlamaio.hrms.business.concreates;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.adapters.ValidationService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verifications.VerificationService;
import kodlamaio.hrms.entities.concreates.Candidate;
import kodlamaio.hrms.entities.concreates.Employer;
import kodlamaio.hrms.entities.concreates.VerificationCode;
import kodlamaio.hrms.entities.dtos.CandidateDto;
import kodlamaio.hrms.entities.dtos.EmployerDto;

@Service
public class AuthManager implements AuthService {

	private ModelMapper modelMapper;
	private CandidateService candidateService;
	private EmployerService employerService;
	private ValidationService validationService;
	private VerificationService verificationService;
	private VerificationCodeService verificationCodeService;

	@Autowired
	public AuthManager(ModelMapper modelMapper, CandidateService candidateService, EmployerService employerService,
			ValidationService validationService, VerificationService verificationService,
			VerificationCodeService verificationCodeService) {
		this.modelMapper = modelMapper;
		this.candidateService = candidateService;
		this.employerService = employerService;
		this.validationService = validationService;
		this.verificationService = verificationService;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public Result candidateRegister(CandidateDto candidateDto) {
		Candidate candidate = modelMapper.map(candidateDto, Candidate.class);
		// Fake Mernis
		if (!this.validationService.CheckIfRealPerson(candidateDto.getFirstName(), candidateDto.getLastName(),
				candidateDto.getIdentificationNumber(), candidateDto.getBirthDate().toString())) {

			return new ErrorResult(Messages.verificationError);
		}

		if (!isEqualsPasswordConfirm(candidateDto.getPassword(), candidateDto.getConfirmPassword())) {
			return new ErrorResult(Messages.passwordNotMatched);
		}

		candidateService.add(candidate);
		// Fake Email
		verificationService.sendEmail(candidateDto.getEmail(),
				verificationCodeService.generateCode(candidate.getId()).getData());

		return new SuccessResult(Messages.registerAndVerification);
	}

	@Override
	public Result employerRegister(EmployerDto employerDto) {
		Employer employer = modelMapper.map(employerDto, Employer.class);

		if (!isEmailEqualsToDomain(employerDto.getEmail(), employerDto.getWebAddress())) {
			return new ErrorResult(Messages.emailEqualsToDomain);

		}

		if (!isEqualsPasswordConfirm(employerDto.getPassword(), employerDto.getConfirmPassword())) {
			return new ErrorResult(Messages.passwordNotMatched);
		}

		this.employerService.add(employer);

		// Fake Email
		verificationService.sendEmail(employerDto.getEmail(),
				verificationCodeService.generateCode(employer.getId()).getData());

		// TODO: Employee Verify

		return new SuccessResult(Messages.registerAndVerification);
	}

	@Override
	public Result emailVerify(String code) {
		VerificationCode verificationCode = this.verificationCodeService.findByCode(code).getData();

		verificationCode.setVerified(true);

		this.verificationCodeService.add(verificationCode);

		return new SuccessResult(Messages.verifiedCandidate);
	}

	// Business Rules

	private boolean isEqualsPasswordConfirm(String password, String confirmPassword) {

		return (password.equals(confirmPassword));
	}

	private boolean isEmailEqualsToDomain(String email, String webAddress) {
		String[] array = email.split("@");
		return array[1].equals(webAddress);
	}

}
