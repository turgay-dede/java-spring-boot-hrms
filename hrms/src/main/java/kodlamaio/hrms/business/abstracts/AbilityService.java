package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.Ability;

public interface AbilityService {
	Result add(Ability ability);

	Result delete(int abilityId);
	
	Result update(Ability ability);

	DataResult<List<Ability>> getAll();

}
