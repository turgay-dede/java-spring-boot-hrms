package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concreates.Candidate;


@Service
public class CandidateManager implements CandidateService {
	
	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;		
	}
		

	@Override
	public DataResult<List<Candidate>> getAll() {		
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),Messages.candidateListed);
	}

	@Override
	public Result add(Candidate candidate) {	
		
		candidate.setId(0);
		
		this.candidateDao.save(candidate);	
		
		return new SuccessResult(Messages.candidateAdded);

	}	

	@Override
	public DataResult<Candidate> findByIdentificationNumber(String identificationNumber) {
		
		Candidate data = this.candidateDao.findByIdentificationNumber(identificationNumber);
		
		if (data != null) {	
			return new SuccessDataResult<Candidate>(data,Messages.listedByIdentificationNumber);			
		}
				
		return new ErrorDataResult<Candidate>(Messages.notFoundByIdentificationNumber);
	}		

}
