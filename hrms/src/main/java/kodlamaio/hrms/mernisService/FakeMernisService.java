package kodlamaio.hrms.mernisService;

public class FakeMernisService {
	public boolean validateRealPersonalInfo(String firstName, String lastName, String identificationNumber, String birthDate) {
		if (firstName.length() >= 3 && lastName.length() >= 2 && identificationNumber.length() == 11
				&& !identificationNumber.startsWith("0") && !birthDate.equals(null)) {
			return true;
		}
		return false;
	}
}
