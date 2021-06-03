package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.VerificationCode;

public interface VerificationCodeService {

	Result add(VerificationCode verificationCode);

	DataResult<String> generateCode(int userId);

	DataResult<VerificationCode> findByCode(String code);

	DataResult<List<VerificationCode>> getAll();

}
