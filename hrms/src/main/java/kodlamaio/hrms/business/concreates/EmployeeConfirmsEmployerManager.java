package kodlamaio.hrms.business.concreates;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeConfirmsEmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
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
	public DataResult<List<EmployeeConfirmsEmployer>> getAll() {
		return new SuccessDataResult<List<EmployeeConfirmsEmployer>>(this.employeeConfirmsEmployerDao.findAll());
	}


	@Override
	public Result verify(int employeeId, int employerId) {	
		EmployeeConfirmsEmployer employeeConfirmsEmployer = new EmployeeConfirmsEmployer();
		employeeConfirmsEmployer.setEmployeeId(employeeId);
		employeeConfirmsEmployer.setEmployerId(employerId);
		employeeConfirmsEmployer.setConfirmed(true);
		employeeConfirmsEmployer.setCreatedAt(LocalDate.now());
		employeeConfirmsEmployer.setStatus(true);
		this.employeeConfirmsEmployerDao.save(employeeConfirmsEmployer);
		return new SuccessResult("İş veren sistem çalışanı tarafından onaylandı");
	}	
	
	

}
