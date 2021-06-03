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

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.School;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {
	private SchoolService schoolService;
	@Autowired
	public SchoolsController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody School school) {
		return this.schoolService.add(school);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int schoolId) {
		return this.schoolService.delete(schoolId);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody School school) {
		return this.schoolService.update(school);
	}
	
	@GetMapping("/getall")
	public DataResult<List<School>> getAll(){
		return this.schoolService.getAll();
	}
	
	@GetMapping("/school/sorted-finishedat")
	public DataResult<List<School>> getAllSchoolByCandidateIdSortedFinishedAt(@RequestParam int candidateId){
		return this.schoolService.getAllSchoolByCandidateIdSortedFinishedAt(candidateId);
	}
}
