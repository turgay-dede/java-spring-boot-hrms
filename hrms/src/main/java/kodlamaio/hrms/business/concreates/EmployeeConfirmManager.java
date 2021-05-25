package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeConfirmService;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeConfirmDao;
import kodlamaio.hrms.entities.concreates.EmployeeConfirm;
@Service
public class EmployeeConfirmManager implements EmployeeConfirmService {
	
	private EmployeeConfirmDao employeeConfirmDao;
@Autowired
	public EmployeeConfirmManager(EmployeeConfirmDao employeeConfirmDao) {
		super();
		this.employeeConfirmDao = employeeConfirmDao;
	}

	@Override
	public List<EmployeeConfirm> getAll() {		
		return this.employeeConfirmDao.findAll();
	}

}
