package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.EducationType;

public interface EducationTypeService {

	Result add(EducationType educationType);

	Result delete(int educationTypeId);

	Result update(EducationType educationType);

	DataResult<List<EducationType>> getAll();

}
