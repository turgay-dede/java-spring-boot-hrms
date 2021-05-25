package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concreates.User;

public interface UserService {
	List<User> getAll();
	DataResult<User> findByEmail(String email);
	
	

}
