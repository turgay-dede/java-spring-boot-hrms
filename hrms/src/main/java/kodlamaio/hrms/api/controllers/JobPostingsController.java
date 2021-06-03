package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.JobPostingAddDto;
import kodlamaio.hrms.entities.dtos.JobPostingDto;


@RestController
@RequestMapping("/api/job-postings")
public class JobPostingsController {
	
	private JobPostingService jobPostingService;
	@Autowired
	public JobPostingsController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPostingAddDto jobPostingAddDto){
		return this.jobPostingService.add(jobPostingAddDto);
	}	
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int jobPostingId){
		return this.jobPostingService.delete(jobPostingId);
	}	
	
	@PutMapping("/update")
	public Result update(@RequestBody JobPostingAddDto jobPostingAddDto){
		return this.jobPostingService.update(jobPostingAddDto);
	}	
	
	@GetMapping("/change-status")
	public Result changeStatus(@RequestParam int id){
		return this.jobPostingService.changeStatus(id);
	}	
	
	@GetMapping("/get/status/true")
	public DataResult<List<JobPostingDto>> getByStatusTrue(){
		return this.jobPostingService.getByStatusTrue();
	}
	
	@GetMapping("/get/company-name/status/true")
	public DataResult<List<JobPostingDto>> getByCompanyNameAndStatusTrue(@RequestParam String companyName){
		return this.jobPostingService.getByCompanyNameAndStatus(companyName);
	}
	
}
