package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concreates.School;

@Service
public class SchoolManager implements SchoolService {
	
	private SchoolDao schoolDao;
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("Okul eklendi");
	}
	
	@Override
	public Result delete(int schoolId) {
		School tempSchool = this.schoolDao.getOne(schoolId);
		this.schoolDao.delete(tempSchool);
		return new SuccessResult("Silindi");
	}

	@Override
	public Result update(School school) {
		School tempSchool = this.schoolDao.getOne(school.getId());
		tempSchool.setEducationType(school.getEducationType());
		tempSchool.setSchoolName(school.getSchoolName());
		tempSchool.setDepartment(school.getDepartment());		
		tempSchool.setResume(school.getResume());
		tempSchool.setStartedAt(school.getStartedAt());
		tempSchool.setFinishedAt(school.getFinishedAt());
		
		this.schoolDao.save(tempSchool);
		return new SuccessResult("Güncellendi");
	}

	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(),"Okullar listelendi");
	}

	@Override
	public DataResult<List<School>> getAllSchoolByCandidateIdSortedFinishedAt(int candidateId) {
		
		return new SuccessDataResult<List<School>>(this.schoolDao.getAllSchoolByCandidateIdSortedFinishedAt(candidateId));
	}

	

}
