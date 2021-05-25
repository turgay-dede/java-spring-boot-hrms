package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.VerificationCode;

public interface VerificationCodeService {
	List<VerificationCode> getAll();
	DataResult<String> generateCode(int userId);
	VerificationCode findByCode(String code);
	Result add(VerificationCode verificationCode);
}