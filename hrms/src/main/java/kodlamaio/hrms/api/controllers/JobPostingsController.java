package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public Result addPosting(@RequestBody JobPostingAddDto jobPostingAddDto){
		return this.jobPostingService.add(jobPostingAddDto);
	}	
	
	@GetMapping("/passiveJobPosting")
	public Result passiveJobPosting(@RequestParam int id){
		return this.jobPostingService.passiveJobPosting(id);
	}	
	
	@GetMapping("/getByStatusTrue")
	public DataResult<List<JobPostingDto>> getByStatusTrue(){
		return this.jobPostingService.getByStatusTrue();
	}
	
	@GetMapping("/getByCompanyNameAndStatusTrue")
	public DataResult<List<JobPostingDto>> getByCompanyNameAndStatusTrue(@RequestParam String companyName){
		return this.jobPostingService.getByCompanyNameAndStatus(companyName);
	}

	@GetMapping("/getAllByStatusTrueSorted")
	public DataResult<List<JobPostingDto>>getAllByStatusTrueSorted(){
		return this.jobPostingService.getAllByStatusTrueSorted();
	}
}
