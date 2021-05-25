package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.JobTitle;

public interface JobTitleService {
	List<JobTitle> getAll();
	Result add(JobTitle jobTitle);
	DataResult<JobTitle> getByTitle(String title);

}