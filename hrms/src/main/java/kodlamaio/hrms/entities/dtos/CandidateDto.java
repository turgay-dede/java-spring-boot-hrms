package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import kodlamaio.hrms.core.utilities.annotations.UniqueEmail;
import kodlamaio.hrms.core.utilities.annotations.UniqueIdentificationNumber;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CandidateDto {
	
	@NotBlank(message="Ad boş geçilemez")
	@Size(min=2,max=20,message="Ad en az 2 karakter en fazla 20 karakter olabilir")
	private String firstName;
	
	@NotBlank(message="Soyad boş geçilemez")
	@Size(min=2,max=20,message="Ad en az 2 karakter en fazla 20 karakter olabilir")
	private String lastName;
	
	@NotBlank(message="Tc kimlik numarası alanı boş geçilemez")
	@Size(min=11,max=11,message="Tc kimlik numarası 11 haneli olmalıdır")
	@UniqueIdentificationNumber
	private String identificationNumber;
	
	//@NotBlank(message="Doğum tarihi alanı boş geçilemez")
	private LocalDate birthDate;
	
	
	@Email(message = "Lütfen geçerli bir e-posta giriniz")
	@NotBlank(message = "E-posta alanı boş olamaz")
	@UniqueEmail
	private String email;
	
	@NotBlank(message = "Şifre boş geçilemez")
	@Size(min = 6, max = 20,message = "Şifreniz en az 6 en fazla 20 karakter olmalıdır")
	private String password;
	
	@NotBlank(message = "Şifre boş geçilemez")
	@Transient
	@JsonProperty(access = Access.WRITE_ONLY)
	private String confirmPassword;

}
