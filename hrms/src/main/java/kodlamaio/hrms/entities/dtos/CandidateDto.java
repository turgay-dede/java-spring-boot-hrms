package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CandidateDto {
	private String firstName;
	private String lastName;
	private String identificationNumber;
	private LocalDate birthDate;
	private String email;
	private String password;
	private String confirmPassword;

}
