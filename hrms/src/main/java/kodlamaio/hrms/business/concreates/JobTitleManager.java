package kodlamaio.hrms.business.concreates;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
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
	Map<String,String> message = new HashMap<String, String>();

	@Override
	public Result add(JobTitle jobTitle) {

		if (JobTitleExists(jobTitle.getTitle())) {
			message.put("jobTitleExists", Messages.jobTitleExists);
			return new ErrorResult(message);
		}

		jobTitle.setId(0);
		this.jobTitleDao.save(jobTitle);
		message.put("jobTitleAdded", Messages.jobTitleAdded);
		return new SuccessResult(message);

	}

	@Override
	public DataResult<JobTitle> getByTitle(String title) {
		JobTitle data = this.jobTitleDao.findByTitle(title);
		if (data != null) {
			message.put("foundJobTitle", Messages.foundJobTitle);
			return new SuccessDataResult<JobTitle>(data,message);
		} else {
			message.put("notFoundJobTitle", Messages.notFoundJobTitle);
			return new ErrorDataResult<>(message);
		}
	}

	// Business Rules

	private boolean JobTitleExists(String title) {
		return this.jobTitleDao.findByTitle(title) != null;
	}

}