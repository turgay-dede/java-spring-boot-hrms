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

import kodlamaio.hrms.business.abstracts.EducationTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.EducationType;

@RestController
@RequestMapping("/api/education-types")
public class EducationTypesController {
	 
	private EducationTypeService educationTypeService;
	@Autowired
	public EducationTypesController(EducationTypeService educationTypeService) {
		super();
		this.educationTypeService = educationTypeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<EducationType>> getAll(){
		return this.educationTypeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EducationType educationType){
		return this.educationTypeService.add(educationType);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int educationTypeId){
		return this.educationTypeService.delete(educationTypeId);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody EducationType educationType){
		return this.educationTypeService.update(educationType);
	}
	
	
}
