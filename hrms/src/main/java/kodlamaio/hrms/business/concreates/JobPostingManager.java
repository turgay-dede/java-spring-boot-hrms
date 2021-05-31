package kodlamaio.hrms.business.concreates;


import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concreates.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingAddDto;
import kodlamaio.hrms.entities.dtos.JobPostingDto;

@Service
public class JobPostingManager implements JobPostingService {
	private JobPostingDao jobPostingDao;
	private ModelMapper modelMapper;
	
	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao,ModelMapper modelMapper) {
		super();
		this.jobPostingDao = jobPostingDao;
		this.modelMapper=modelMapper;
	}	
	
	@Override
	public Result add(JobPostingAddDto jobPostingAddDto) {
		
		JobPosting jobPosting = modelMapper.map(jobPostingAddDto, JobPosting.class);
		
		jobPosting.setId(0);
		
		jobPosting.setCreatedAt(LocalDate.now());
		
		this.jobPostingDao.save(jobPosting);	
		
		return new SuccessResult(Messages.addJobPosting);
	}
	
	@Override
	public Result passiveJobPosting(int id) {
		
		JobPosting tempJobPosting = this.jobPostingDao.getOne(id);	
		
		tempJobPosting.setStatus(false);
		
		this.jobPostingDao.save(tempJobPosting);

		return new SuccessResult(Messages.passiveJobPosting);
	}

	@Override
	public DataResult<List<JobPostingDto>> getByStatusTrue() {	
		
		return new SuccessDataResult<List<JobPostingDto>>(this.jobPostingDao.getByStatusTrue(),Messages.activeJobPostingListed);
	}

	@Override
	public DataResult<List<JobPostingDto>> getByCompanyNameAndStatus(String companyName) {		
		
		var result = this.jobPostingDao.getByCompanyNameAndStatus(companyName);
		
		if(result.isEmpty() || result == null) {		
			 return new ErrorDataResult<>(Messages.notFoundActiveJobPosting);			 
		}	
		
		return new SuccessDataResult<List<JobPostingDto>>(result,Messages.companyActivePostingListed);
	}

	@Override
	public DataResult<List<JobPostingDto>> getAllByStatusTrueSorted() {
		
		var result = this.jobPostingDao.getByStatusTrue();
		
		 var sortedResult = result.stream()
	                .sorted(Comparator.comparing(JobPostingDto::getCreatedAt).reversed())
	                .collect(Collectors.toList());
		 
		 if(result.isEmpty() || result == null) {		 
		
			 return new ErrorDataResult<>(Messages.notFoundActiveJobPosting);			 
		 }		
		 
		 return new SuccessDataResult<>(sortedResult,Messages.activeJobPostingListed);		
	}

}
