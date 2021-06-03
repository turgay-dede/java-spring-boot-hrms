package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concreates.User;

public interface UserService {

	DataResult<User> findByEmail(String email);
	
	DataResult<List<User>> getAll();
	
	

}
