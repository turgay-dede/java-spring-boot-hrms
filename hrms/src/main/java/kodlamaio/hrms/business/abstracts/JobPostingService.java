package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.JobPostingAddDto;
import kodlamaio.hrms.entities.dtos.JobPostingDto;

public interface JobPostingService {
	Result add(JobPostingAddDto jobPostingAddDto);
	
	Result delete(int jobPostingId);
	
	Result update(JobPostingAddDto jobPostingAddDto);
	
	Result changeStatus(int id);
	
	DataResult<List<JobPostingDto>> getByStatusTrue();
	
	DataResult<List<JobPostingDto>> getAllByStatusTrueSorted();
	
	DataResult<List<JobPostingDto>> getByCompanyNameAndStatus(String companyName);

}
