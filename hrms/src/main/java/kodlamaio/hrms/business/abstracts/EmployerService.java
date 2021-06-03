package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.Employer;

public interface EmployerService {

	Result add(Employer employer);
	
	Result delete(int employerId);
	
	Result update(Employer employer);

	DataResult<Employer> getById(int id);

	DataResult<List<Employer>> getAll();

}
