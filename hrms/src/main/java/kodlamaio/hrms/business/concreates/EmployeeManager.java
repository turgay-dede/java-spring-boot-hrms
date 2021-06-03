package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
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
	public DataResult<List<Employee>> getAll() {

		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll());
	}

	@Override
	public Result add(Employee employee) {
		this.employeeDao.save(employee);
		return new SuccessResult();
	}

	@Override
	public DataResult<Employee> getById(int id) {

		return new SuccessDataResult<Employee>(this.employeeDao.getOne(id));
	}

	@Override
	public Result delete(int employeeId) {
		Employee tempEmployee = this.employeeDao.getOne(employeeId);
		this.employeeDao.delete(tempEmployee);
		return new SuccessResult("Silindi");
	}

	@Override
	public Result update(Employee employee) {
		Employee tempEmployee = this.employeeDao.getOne(employee.getId());
		tempEmployee.setFirstName(employee.getFirstName());
		tempEmployee.setLastName(employee.getLastName());
		tempEmployee.setEmail(employee.getEmail());
		tempEmployee.setPassword(employee.getPassword());
		this.employeeDao.save(tempEmployee);
		return new SuccessResult("Güncellendi");
	}

}
