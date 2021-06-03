package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concreates.City;

@Service
public class CityManager implements CityService {
	
	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {		
		return new SuccessDataResult<List<City>>(this.cityDao.findAll());
	}

	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		
		return new SuccessResult();
	}

	@Override
	public Result delete(int cityId) {
		City tempCity = this.cityDao.getOne(cityId);
		this.cityDao.delete(tempCity);
		return new SuccessResult("Silindi");
	}

	@Override
	public Result update(City city) {
		City tempCity = this.cityDao.getOne(city.getId());
		tempCity.setCityName(city.getCityName());
		this.cityDao.save(tempCity);
		return new SuccessResult("Güncellendi");
	}

}
