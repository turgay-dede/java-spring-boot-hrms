package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.concreates.JobTitle;

public interface JobTitleService {
	List<JobTitle> getAll();

}