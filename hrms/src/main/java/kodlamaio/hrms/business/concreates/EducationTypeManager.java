package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationTypeDao;
import kodlamaio.hrms.entities.concreates.EducationType;

@Service
public class EducationTypeManager implements EducationTypeService {
	
	private EducationTypeDao educationTypeDao;
	
	@Autowired
	public EducationTypeManager(EducationTypeDao educationTypeDao) {
		super();
		this.educationTypeDao = educationTypeDao;
	}

	@Override
	public DataResult<List<EducationType>> getAll() {
		
		return new SuccessDataResult<List<EducationType>>(this.educationTypeDao.findAll());
	}

	@Override
	public Result add(EducationType educationType) {
		this.educationTypeDao.save(educationType);
		return new SuccessResult();
	}

	@Override
	public Result delete(int educationTypeId) {
		EducationType tempEducationType = this.educationTypeDao.getOne(educationTypeId);
		this.educationTypeDao.delete(tempEducationType);
		return new SuccessResult("Silindi");
	}

	@Override
	public Result update(EducationType educationType) {
		EducationType tempEducationType = this.educationTypeDao.getOne(educationType.getId());
		tempEducationType.setTitle(educationType.getTitle());
		this.educationTypeDao.save(tempEducationType);
		return new SuccessResult("Güncellendi");
	}

}
