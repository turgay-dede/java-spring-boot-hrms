package kodlamaio.hrms.core.utilities.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concreates.JobTitle;

public class UniqueJobTitleValidator implements ConstraintValidator<UniqueJobTitle, String>  {
	
	@Autowired
	JobTitleDao jobTitleDao;
	
	@Override
	public boolean isValid(String title, ConstraintValidatorContext context) {
		JobTitle jobTitle = this.jobTitleDao.findByTitle(title);
		
		if(jobTitle != null) {
			return false;
		}
		return true;
	}
	
	
	


}
