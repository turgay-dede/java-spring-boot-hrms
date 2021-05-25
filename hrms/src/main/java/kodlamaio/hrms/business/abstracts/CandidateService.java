package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.Candidate;

public interface CandidateService {

	DataResult<List<Candidate>> getAll();

	DataResult<Candidate> findByIdentificationNumber(String identificationNumber);

	Result add(Candidate candidate);

}