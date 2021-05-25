package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidateDto;
import kodlamaio.hrms.entities.dtos.EmployerDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private AuthService authService;
	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/register-candidate")
	public Result registerToCandidate(@RequestBody CandidateDto candidateDto) {
		return this.authService.registerToCandidate(candidateDto);
		
	}
	@PostMapping("/register-employer")
	public Result registerToEmployer(@RequestBody EmployerDto employerDto) {
		return this.authService.registerToEmployer(employerDto);
		
	}
	
	@GetMapping("/verify-employer")
	public Result verifyEmployer(int employerId) {		
		return this.authService.verifyToEmployer(employerId);
	}
	
	@GetMapping("/verify-candidate")
	public Result verifyCandidate(String code) {		
		return this.authService.verifyToCandidate(code);
	}
	
	

}
