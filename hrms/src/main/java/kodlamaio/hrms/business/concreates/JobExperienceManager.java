package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.entities.concreates.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService {
	private JobExperienceDao jobExperienceDao;

	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public Result add(JobExperience jobExperience) {
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll());
	}

	@Override
	public DataResult<List<JobExperience>> getAllJobExByCandidateIdSortedFinishedAt(int candidateId) {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.getAllJobExByCandidateIdSortedFinishedAt(candidateId));
	}

	@Override
	public Result delete(int jobExperienceId) {
		JobExperience tempJobExperience = this.jobExperienceDao.getOne(jobExperienceId);
		this.jobExperienceDao.delete(tempJobExperience);
		return new SuccessResult("Silindi");
	}

	@Override
	public Result update(JobExperience jobExperience) {
		JobExperience tempJobExperience = this.jobExperienceDao.getOne(jobExperience.getId());
		tempJobExperience.setCompanyName(jobExperience.getCompanyName());
		tempJobExperience.setPosition(jobExperience.getPosition());
		tempJobExperience.setResume(jobExperience.getResume());
		
		this.jobExperienceDao.save(tempJobExperience);	
		
		return new SuccessResult("Güncellendi");
	}

}
