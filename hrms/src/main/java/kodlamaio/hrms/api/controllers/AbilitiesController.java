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

import kodlamaio.hrms.business.abstracts.AbilityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.Ability;

@RestController
@RequestMapping("/api/abilities")
public class AbilitiesController {
	private AbilityService abilityService;
	
	@Autowired
	public AbilitiesController(AbilityService abilityService) {
		super();
		this.abilityService = abilityService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Ability ability) {
		return this.abilityService.add(ability);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int abilityId) {
		return this.abilityService.delete(abilityId);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody Ability ability) {
		return this.abilityService.update(ability);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Ability>> getAll(){
		return this.abilityService.getAll();
	}

}
