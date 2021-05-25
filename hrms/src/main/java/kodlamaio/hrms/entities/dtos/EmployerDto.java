package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployerDto {
	private String companyName;
	private String webAddress;
	private String email;
	private String phoneNumber;
	private String password;
	private String confirmPassword;

}
