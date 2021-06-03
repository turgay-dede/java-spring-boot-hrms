package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.JobExperience;

public interface JobExperienceService {
	Result add(JobExperience jobExperience);	
	
	Result delete(int jobExperienceId);
	
	Result update(JobExperience jobExperience);

	DataResult<List<JobExperience>> getAllJobExByCandidateIdSortedFinishedAt(int candidateId);
	
	DataResult<List<JobExperience>> getAll();

}
