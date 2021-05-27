package kodlamaio.hrms.business.concreates;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concreates.User;

@Service
public class UserManager implements UserService{
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	Map<String,String> message = new HashMap<String, String>();


	@Override
	public List<User> getAll() {
		return this.userDao.findAll();
	}
	
	@Override
	public DataResult<User> findByEmail(String email) {
		
		User data = this.userDao.findByEmail(email);
		if (data != null) {
			message.put("listedByEmail", Messages.listedByEmail);
			return new SuccessDataResult<User>(data,message);			
		}
		message.put("notFoundByEmail", Messages.notFoundByEmail);
		return new ErrorDataResult<User>(message);
		
	}
}
