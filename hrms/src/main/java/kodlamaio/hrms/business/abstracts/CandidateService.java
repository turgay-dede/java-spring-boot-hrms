package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.Candidate;

public interface CandidateService {
	
	Result add(Candidate candidate);
	
	Result delete(int candidateId);
	
	Result softDelete(int candidateId);
	
	Result update(Candidate candidate);

	DataResult<List<Candidate>> getAll();

	DataResult<Candidate> findByIdentificationNumber(String identificationNumber);

	

}
