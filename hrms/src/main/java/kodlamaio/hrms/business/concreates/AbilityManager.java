package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AbilityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.AbilityDao;
import kodlamaio.hrms.entities.concreates.Ability;

@Service
public class AbilityManager implements AbilityService {

	private AbilityDao abilityDao;

	@Autowired
	public AbilityManager(AbilityDao abilityDao) {
		super();
		this.abilityDao = abilityDao;
	}

	@Override
	public DataResult<List<Ability>> getAll() {
		return new SuccessDataResult<List<Ability>>(this.abilityDao.findAll());
	}

	@Override
	public Result add(Ability educationType) {
		this.abilityDao.save(educationType);
		return new SuccessResult();
	}

	@Override
	public Result delete(int abilityId) {
		Ability tempAbility = this.abilityDao.getOne(abilityId);
		this.abilityDao.delete(tempAbility);
		return new SuccessResult("Silindi");
	}		
	
	@Override
	public Result update(Ability ability) {
		Ability tempAbility = this.abilityDao.getOne(ability.getId());
		tempAbility.setAbilityName(ability.getAbilityName());
		tempAbility.setResume(ability.getResume());
		this.abilityDao.save(tempAbility);

		
		return new SuccessResult("Güncellendi");
	}

}
