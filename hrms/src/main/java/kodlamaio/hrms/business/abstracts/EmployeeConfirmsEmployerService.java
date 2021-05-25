package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.concreates.EmployeeConfirmsEmployer;

public interface EmployeeConfirmsEmployerService {
	List<EmployeeConfirmsEmployer> getAll();	
	EmployeeConfirmsEmployer findByEmployer(int employerId);
	void add(EmployeeConfirmsEmployer employeeConfirmsEmployer);

}
