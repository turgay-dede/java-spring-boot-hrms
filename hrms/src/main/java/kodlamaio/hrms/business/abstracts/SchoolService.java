package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.School;

public interface SchoolService {
	Result add(School school);
	
	Result delete(int schoolId);
	
	Result update(School school);

	DataResult<List<School>> getAll();

	DataResult<List<School>> getAllSchoolByCandidateIdSortedFinishedAt(int candidateId);

}
