package kodlamaio.hrms.core.verifications;

import org.springframework.stereotype.Repository;

@Repository
public class MailManager implements VerificationService {

	@Override
	public void sendEmail(String email, String code) {
		System.out.println("Doğrulama kodu " + email + " adresine gönderildi. Kod: " + code);
	}

}
