package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concreates.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {
	JobTitleDao jobTitleDao;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public List<JobTitle> getAll() {
		return this.jobTitleDao.findAll();
	}


	@Override
	public Result add(JobTitle jobTitle) {

		jobTitle.setId(0);
		
		this.jobTitleDao.save(jobTitle);
		
		return new SuccessResult(Messages.jobTitleAdded);
	}

	@Override
	public DataResult<JobTitle> getByTitle(String title) {
		
		JobTitle data = this.jobTitleDao.findByTitle(title);
		
		if (data != null) {
			
			return new SuccessDataResult<JobTitle>(data,Messages.foundJobTitle);			
		}	
		
		return new ErrorDataResult<>(Messages.notFoundJobTitle);
	}

	// Business Rules


}