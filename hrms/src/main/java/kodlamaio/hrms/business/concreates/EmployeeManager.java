package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concreates.Employee;

@Service
public class EmployeeManager implements EmployeeService {
	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}


	@Override
	public List<Employee> getAll() {
		
		return this.employeeDao.findAll();
	}

}
