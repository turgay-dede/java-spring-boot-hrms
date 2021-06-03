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
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concreates.Resume;


@RestController
@RequestMapping("/api/resumes")
public class ResumesController {
	private ResumeService resumeService;
	
	@Autowired
	public ResumesController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Resume resume) {		

		this.resumeService.add(resume);
				
		return new SuccessResult();			
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int resumeId) {		

		this.resumeService.delete(resumeId);
				
		return new SuccessResult();			
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody Resume resume) {		

		this.resumeService.update(resume);
				
		return new SuccessResult();			
	}
	
	@GetMapping("/getall")
	public DataResult<List<Resume>> getAll(){
		return this.resumeService.getAll();
	}
	
	@GetMapping("/get/id")
	public DataResult<List<Resume>> getById(@RequestParam int candidateId){
		return this.resumeService.getById(candidateId);
	}
	
	@GetMapping("/getall/sorted")
	public DataResult<List<Resume>> getAllSorted(){
		return this.resumeService.getAllResumeSortedByCreatedAt();
	}
	
	@PutMapping("/upload/photo")
	public Result saveImage(@RequestBody MultipartFile file,@RequestParam int resumeId) {
		return this.resumeService.savePhoto(file, resumeId);
		
	}
	
}
