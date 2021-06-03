package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.JobExperience;

@RestController
@RequestMapping("/api/job-experiences")
public class JobExperiencesController {
	
	private JobExperienceService jobExperienceService;
	
	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobExperience jobExperience) {
		return this.jobExperienceService.add(jobExperience);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int jobExperienceId) {
		return this.jobExperienceService.delete(jobExperienceId);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody JobExperience jobExperience) {
		return this.jobExperienceService.update(jobExperience);
	}
	
	@GetMapping("/getall")
	public Result getAll() {
		return this.jobExperienceService.getAll();
	}
	
	@GetMapping("/job-experince/sorted-finishedat")
	public Result getAllJobExByCandidateIdSortedFinishedAt(@RequestParam int candidateId) {
		return this.jobExperienceService.getAllJobExByCandidateIdSortedFinishedAt(candidateId);
	}

}
