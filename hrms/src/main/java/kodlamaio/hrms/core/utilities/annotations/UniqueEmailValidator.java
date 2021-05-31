package kodlamaio.hrms.core.utilities.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concreates.User;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
	@Autowired
	UserDao userDao;

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		User user = this.userDao.findByEmail(email);
		if(user != null) {
			return false;
		}
		return true;
	}

}
