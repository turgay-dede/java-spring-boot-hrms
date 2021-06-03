package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.Language;

public interface LanguageService {
	Result add(Language language);
	
	Result delete(int languageId);
	
	Result update(Language language);

	DataResult<List<Language>> getAll();

}
