package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidateDto;
import kodlamaio.hrms.entities.dtos.EmployerDto;

public interface AuthService {
	Result registerToCandidate(CandidateDto candidateDto);
	Result registerToEmployer(EmployerDto employerDto);
	Result verifyToEmployer(int employerId);
	Result verifyToCandidate(String code);
}
