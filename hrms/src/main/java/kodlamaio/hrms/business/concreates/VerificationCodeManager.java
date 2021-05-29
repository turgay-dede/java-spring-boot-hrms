package kodlamaio.hrms.business.concreates;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	Map<String, String> message = new HashMap<String, String>();
	

	@Override
	public List<VerificationCode> getAll() {
		return this.verificationCodeDao.findAll();
	}	

	@Override
	public DataResult<String> generateCode(int userId) {
		message.clear();
		
		Map<String, String> messageMap = new HashMap<String, String>();
		
		String code = UUID.randomUUID().toString();
		
		VerificationCode verificationCode = new VerificationCode();
		
		verificationCode.setUserId(userId);
		
		verificationCode.setCode(code);
		
		this.verificationCodeDao.save(verificationCode);
		
		messageMap.put("codeGenerated", Messages.codeGenerated);
		
		return new SuccessDataResult<String>(code,messageMap);
	}

	@Override
	public VerificationCode findByCode(String code) {
		
		return this.verificationCodeDao.findByCode(code);
	}

	@Override
	public Result add(VerificationCode verificationCode) {
		message.clear();
		
		Map<String, String> messageMap = new HashMap<String, String>();
		
		this.verificationCodeDao.save(verificationCode);
		
		messageMap.put("verificationCodeAdded", Messages.verificationCodeAdded);
		
		return new SuccessResult(messageMap);
	}	

}
