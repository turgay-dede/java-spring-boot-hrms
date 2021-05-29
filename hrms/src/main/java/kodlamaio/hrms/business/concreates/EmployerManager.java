package kodlamaio.hrms.business.concreates;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concreates.Employer;


@Service
public class EmployerManager implements EmployerService {
	private EmployerDao employerDao;


	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;		
	}
	
	Map<String, String> message = new HashMap<String, String>();
	
	@Override
	public List<Employer> getAll() {
		return this.employerDao.findAll();
	}

	@Override
	public Result add(Employer employer) {
		message.clear();
		
		if (!isRealPhoneNumber(employer)) {
			message.put("invalidPhoneNumber", Messages.invalidPhoneNumber);
			return new ErrorResult(message);
		}

		this.employerDao.save(employer);
		
		message.put("emloyerAdded", Messages.emloyerAdded);
		
		return new SuccessResult(message);
	}
	
	

	
	
	
	//Business Rules
	
	private boolean isRealPhoneNumber(Employer employer) {

		String patterns = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
				+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
				+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

		Pattern pattern = Pattern.compile(patterns);
		
		Matcher matcher = pattern.matcher(employer.getPhoneNumber());
		
		if (!matcher.matches()) {
			return false;
		}
		
		return true;

	}

	

}
