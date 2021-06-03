package kodlamaio.hrms.business.concreates;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.AbilityService;
import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.cloudinary.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concreates.Ability;
import kodlamaio.hrms.entities.concreates.JobExperience;
import kodlamaio.hrms.entities.concreates.Language;
import kodlamaio.hrms.entities.concreates.Resume;
import kodlamaio.hrms.entities.concreates.School;

@Service
public class ResumeManager implements ResumeService {
	private ResumeDao resumeDao;
	private CloudinaryService cloudinaryService;
	private AbilityService abilityService;
	private JobExperienceService jobExperienceService;
	private SchoolService schoolService;
	private LanguageService languageService;


	
	@Autowired
	public ResumeManager(ResumeDao resumeDao,AbilityService abilityService,JobExperienceService jobExperienceService,SchoolService schoolService,LanguageService languageService,CloudinaryService cloudinaryService) {
		super();
		this.resumeDao = resumeDao;
		this.abilityService=abilityService;
		this.jobExperienceService=jobExperienceService;
		this.schoolService=schoolService;
		this.languageService=languageService;
		this.cloudinaryService=cloudinaryService;
		
	}
	
	@Override
	public DataResult<Resume> add(Resume resume) {	
		Resume tempResume = this.resumeDao.save(resume);
		
		setResume(tempResume);		
		
		return new SuccessDataResult<Resume>(tempResume);
	}
	
	@Override
	public Result delete(int resumeId) {
		Resume tempResume = this.resumeDao.getOne(resumeId);
		this.resumeDao.delete(tempResume);
		return new SuccessResult("Silindi");
	}

	@Override
	public Result update(Resume resume) {
		Resume tempResume = this.resumeDao.getOne(resume.getId());
		
		tempResume.setAbilities(resume.getAbilities());	
		tempResume.setCandidate(resume.getCandidate());
		tempResume.setDescription(resume.getDescription());
		tempResume.setGithubLink(resume.getGithubLink());
		tempResume.setJobExperiences(resume.getJobExperiences());
		tempResume.setLanguages(resume.getLanguages());
		tempResume.setLinkedLink(resume.getLinkedLink());
		tempResume.setPhotoUrl(resume.getPhotoUrl());
		tempResume.setSchools(resume.getSchools());
		tempResume.setUpdatedAt(LocalDate.now());
		tempResume.setActive(resume.isActive());
		
		this.resumeDao.save(tempResume);
		
		setResume(tempResume);			
		
		return new SuccessResult("Güncellendi");
	}	

	@Override
	public DataResult<List<Resume>> getAll() {
		
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll());
	}

	@Override
	public DataResult<List<Resume>> getById(int candidateId) {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findByCandidate_Id(candidateId));
	}

	@Override
	public Result savePhoto(MultipartFile file, int resumeId) {
		Map<String, String> uploader = (Map<String, String>) cloudinaryService.save(file).getData(); 
		String photoUrl= uploader.get("url");
		Resume resume = resumeDao.getOne(resumeId);
		resume.setPhotoUrl(photoUrl);
		resumeDao.save(resume);
		return new SuccessResult("Kayıt Başarılı");
	}

	@Override
	public DataResult<List<Resume>> getAllResumeSortedByCreatedAt() {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.getAllResumeSortedByCreatedAt());
	}
	
	
	private void setResume(Resume tempResume) {
		
		if(tempResume.getAbilities() != null) {
			for (Ability abiity : tempResume.getAbilities()) {
				abiity.setResume(tempResume);
				abilityService.add(abiity);
			}
			
		}
		
		if(tempResume.getJobExperiences() != null) {
			for (JobExperience jobExperience : tempResume.getJobExperiences()) {
				jobExperience.setResume(tempResume);
				jobExperienceService.add(jobExperience);
			}
		}
		
		if(tempResume.getSchools() != null) {
			for (School school : tempResume.getSchools()) {
				school.setResume(tempResume);
				schoolService.add(school);
			}
		}
		
		if(tempResume.getLanguages() != null) {
			for (Language language : tempResume.getLanguages()) {
				language.setResume(tempResume);
				languageService.add(language);
			}
		}			
	}

	
	
}
