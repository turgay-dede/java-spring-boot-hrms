package kodlamaio.hrms.core.utilities.adapters;

import org.springframework.stereotype.Repository;

import kodlamaio.hrms.mernisService.FakeMernisService;
@Repository
public class MernisServiceAdapter implements ValidationService {

	@Override
	public boolean CheckIfRealPerson(String firstName, String lastName, String identificationNumber, String birthDate) {
		FakeMernisService client = new FakeMernisService();
		boolean result= true;
		try {
			result = client.validateRealPersonalInfo(firstName, lastName, identificationNumber, birthDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	

}
