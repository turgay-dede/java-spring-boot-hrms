package kodlamaio.hrms.business.concreates;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.hrms.entities.concreates.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {

	private VerificationCodeDao verificationCodeDao;

	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}	

	@Override
	public DataResult<List<VerificationCode>> getAll() {
		return new SuccessDataResult<List<VerificationCode>>(this.verificationCodeDao.findAll());
	}	

	@Override
	public DataResult<String> generateCode(int userId) {			
		
		String code = UUID.randomUUID().toString();
		
		VerificationCode verificationCode = new VerificationCode();
		
		verificationCode.setUserId(userId);
		
		verificationCode.setCode(code);
		
		this.verificationCodeDao.save(verificationCode);
		
		return new SuccessDataResult<String>(code,Messages.codeGenerated);
	}

	@Override
	public DataResult<VerificationCode> findByCode(String code) {
		
		return new SuccessDataResult<VerificationCode>(this.verificationCodeDao.findByCode(code));
	}

	@Override
	public Result add(VerificationCode verificationCode) {		
		
		this.verificationCodeDao.save(verificationCode);
		
		return new SuccessResult( Messages.verificationCodeAdded);
	}	

}
