package kodlamaio.hrms.core.utilities.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concreates.Candidate;

public class UniqueIdentificationNumberValidator implements ConstraintValidator<UniqueIdentificationNumber, String>  {
	@Autowired
	CandidateDao candidateDao;
	
	@Override
	public boolean isValid(String identificationNumber, ConstraintValidatorContext context) {
		Candidate candidate = this.candidateDao.findByIdentificationNumber(identificationNumber);
		if(candidate != null) {
			return false;
		}
		return true;
	}

}
