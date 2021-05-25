package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployeeConfirmsEmployerService;
import kodlamaio.hrms.entities.concreates.EmployeeConfirmsEmployer;

@RestController
@RequestMapping("/api/employeeconfirmsemployers")
public class EmployeeConfirmsEmployersController {
	private EmployeeConfirmsEmployerService employeeConfirmsEmployerService;

	@Autowired
	public EmployeeConfirmsEmployersController(EmployeeConfirmsEmployerService employeeConfirmsEmployerService) {
		super();
		this.employeeConfirmsEmployerService = employeeConfirmsEmployerService;
	}
	
	@GetMapping("/getall")
	public List<EmployeeConfirmsEmployer> getAll(){
		return this.employeeConfirmsEmployerService.getAll();
	}

}
