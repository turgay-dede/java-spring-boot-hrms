package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployeeConfirmsEmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
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
	public DataResult<List<EmployeeConfirmsEmployer>> getAll(){
		return this.employeeConfirmsEmployerService.getAll();
	}
	
	@PostMapping("/verify-employer")
	public Result verifyEmployer(@RequestParam int employeeId, @RequestParam int employerId) {
		return this.employeeConfirmsEmployerService.verify(employeeId, employerId);
	}

}
