package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concreates.Language;

@Service
public class LanguageManager implements LanguageService {
	private LanguageDao languageDao;
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult();
	}
	
	@Override
	public Result delete(int languageId) {
		Language tempLangueage = this.languageDao.getOne(languageId);
		this.languageDao.delete(tempLangueage);
		return new SuccessResult("Silindi");
	}

	@Override
	public Result update(Language language) {
		Language tempLangueage = this.languageDao.getOne(language.getId());
		tempLangueage.setLanguageName(language.getLanguageName());
		tempLangueage.setLanguageLevel(language.getLanguageLevel());
		tempLangueage.setResume(language.getResume());
		
		this.languageDao.save(tempLangueage);
		
		return new SuccessResult("Güncellendi");
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll());
	}

	

}
