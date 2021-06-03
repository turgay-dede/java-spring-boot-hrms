package kodlamaio.hrms.business.concreates;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
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
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public Result add(Employer employer) {

		employer.setCreatedAt(LocalDate.now());

		this.employerDao.save(employer);	
		
		return new SuccessResult(Messages.emloyerAdded);
	}

	@Override
	public DataResult<Employer> getById(int id) {
		
		return new SuccessDataResult<Employer>(this.employerDao.getOne(id));
	}

	@Override
	public Result delete(int employerId) {
		Employer tempEmployer = this.employerDao.getOne(employerId);
		this.employerDao.delete(tempEmployer);
		return new SuccessResult("Silindi");
	}

	@Override
	public Result update(Employer employer) {
		Employer tempEmployer = this.employerDao.getOne(employer.getId());
		tempEmployer.setCompanyName(employer.getCompanyName());
		tempEmployer.setEmail(employer.getEmail());
		tempEmployer.setWebAddress(employer.getWebAddress());
		tempEmployer.setPassword(employer.getPassword());
		tempEmployer.setPhoneNumber(employer.getPhoneNumber());
		
		this.employerDao.save(tempEmployer);
		
		return new SuccessResult("Güncellendi");
	}	

}
