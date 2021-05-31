package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidateDto;
import kodlamaio.hrms.entities.dtos.EmployerDto;

public interface AuthService {
	Result candidateRegister(CandidateDto candidateDto);
	Result employerRegister(EmployerDto employerDto);
	Result emailVerify(String code);	
}
