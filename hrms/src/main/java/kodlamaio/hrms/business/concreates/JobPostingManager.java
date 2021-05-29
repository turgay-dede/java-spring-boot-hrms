package kodlamaio.hrms.business.concreates;


import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	Map<String, String> message = new HashMap<String, String>();
	
	@Override
	public Result add(JobPostingAddDto jobPostingAddDto) {
		message.clear();
		
		JobPosting jobPosting = modelMapper.map(jobPostingAddDto, JobPosting.class);
		
		jobPosting.setId(0);
		
		jobPosting.setCreatedAt(LocalDate.now());
		
		this.jobPostingDao.save(jobPosting);
		
		message.put("add", Messages.addJobPosting);
		
		return new SuccessResult(message);
	}
	
	@Override
	public Result passiveJobPosting(int id) {
		message.clear();
		
		JobPosting tempJobPosting = this.jobPostingDao.getOne(id);	
		
		tempJobPosting.setStatus(false);
		
		this.jobPostingDao.save(tempJobPosting);
		
		message.put("passive", Messages.passiveJobPosting);
		
		return new SuccessResult(message);
	}

	@Override
	public DataResult<List<JobPostingDto>> getByStatusTrue() {
		message.clear();
		
		message.put("active",Messages.activeJobPostingListed);
		
		return new SuccessDataResult<List<JobPostingDto>>(this.jobPostingDao.getByStatusTrue(),message);
	}

	@Override
	public DataResult<List<JobPostingDto>> getByCompanyNameAndStatus(String companyName) {
		message.clear();
		
		var result = this.jobPostingDao.getByCompanyNameAndStatus(companyName);
		
		if(result.isEmpty() || result == null) {
			 message.put("not-found-company-active", Messages.notFoundActiveJobPosting);
			 return new ErrorDataResult<>(message);			 
		}
		
		message.put("company-active", Messages.companyActivePostingListed);
		
		return new SuccessDataResult<List<JobPostingDto>>(result,message);
	}

	@Override
	public DataResult<List<JobPostingDto>> getAllByStatusTrueSorted() {
		message.clear();
		
		var result = this.jobPostingDao.getByStatusTrue();
		
		 var sortedResult = result.stream()
	                .sorted(Comparator.comparing(JobPostingDto::getCreatedAt).reversed())
	                .collect(Collectors.toList());
		 
		 if(result.isEmpty() || result == null) {			 
			 message.put("not-found-active-posting", Messages.notFoundActiveJobPosting);
			 return new ErrorDataResult<>(message);			 
		 }		 
		
		 message.put("sorted-actives", Messages.activeJobPostingListed);
		 
		 return new SuccessDataResult<>(sortedResult,message);		
	}	


}
