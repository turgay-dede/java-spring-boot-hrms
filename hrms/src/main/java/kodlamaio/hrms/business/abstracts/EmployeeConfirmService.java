package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concreates.EmployeeConfirm;

public interface EmployeeConfirmService {
	
	DataResult<List<EmployeeConfirm>> getAll();

}
