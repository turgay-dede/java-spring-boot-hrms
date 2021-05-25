package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeConfirmsEmployerService;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeConfirmsEmployerDao;
import kodlamaio.hrms.entities.concreates.EmployeeConfirmsEmployer;

@Service
public class EmployeeConfirmsEmployerManager implements EmployeeConfirmsEmployerService {
	private EmployeeConfirmsEmployerDao employeeConfirmsEmployerDao;

	@Autowired
	public EmployeeConfirmsEmployerManager(EmployeeConfirmsEmployerDao employeeConfirmsEmployerDao) {
		super();
		this.employeeConfirmsEmployerDao = employeeConfirmsEmployerDao;
	}

	@Override
	public List<EmployeeConfirmsEmployer> getAll() {
		return this.employeeConfirmsEmployerDao.findAll();
	}

	@Override
	public EmployeeConfirmsEmployer findByEmployer(int employerId) {
		
		return this.employeeConfirmsEmployerDao.findByEmployerId(employerId);
	}

	@Override
	public void add(EmployeeConfirmsEmployer employeeConfirmsEmployer) {
		this.employeeConfirmsEmployerDao.save(employeeConfirmsEmployer);
		
	}	

}
