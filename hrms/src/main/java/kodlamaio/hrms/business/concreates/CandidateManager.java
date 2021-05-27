package kodlamaio.hrms.business.concreates;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	Map<String,String> message = new HashMap<String, String>();

	@Override
	public DataResult<List<Candidate>> getAll() {
		message.put("candidateListed", Messages.candidateListed );
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),message);
	}

	@Override
	public Result add(Candidate candidate) {	

		candidate.setId(0);
		this.candidateDao.save(candidate);
		message.put("candidateAdd", Messages.candidateAdded);
		return new SuccessResult(message);

	}	

	@Override
	public DataResult<Candidate> findByIdentificationNumber(String identificationNumber) {
		Candidate data = this.candidateDao.findByIdentificationNumber(identificationNumber);
		if (data != null) {
			message.put("listedByIdentificationNumber", Messages.listedByIdentificationNumber);
			return new SuccessDataResult<Candidate>(data,message);			
		}
		message.put("notFoundByIdentificationNumber", Messages.notFoundByIdentificationNumber);
		return new ErrorDataResult<Candidate>(message);
	}		

}
