package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
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

}