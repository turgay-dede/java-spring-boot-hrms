package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.Candidate;


@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {	
		this.candidateService = candidateService;		
	}	
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}	
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody Candidate candidate) {
		return this.candidateService.add(candidate);

	}
	
	@DeleteMapping("/delete")
	public Result delete(@Valid @RequestParam int candidateId) {
		return this.candidateService.delete(candidateId);

	}
	
	@PutMapping("/soft-delete")
	public Result softDelete(@Valid @RequestParam int candidateId) {
		return this.candidateService.softDelete(candidateId);

	}
	
	@PutMapping("/update")
	public Result update(@Valid @RequestBody Candidate candidate) {
		return this.candidateService.update(candidate);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException
	(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors 
		= new ErrorDataResult<Object>(validationErrors);
		return errors;
	}
	
	
}
