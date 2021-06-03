package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.EmployeeConfirmsEmployer;

public interface EmployeeConfirmsEmployerService {	
	
	Result verify(int employeeId,int employerId);
	
	DataResult<List<EmployeeConfirmsEmployer>> getAll();

}
