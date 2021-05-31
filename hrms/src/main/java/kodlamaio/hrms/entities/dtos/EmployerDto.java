package kodlamaio.hrms.entities.dtos;

import javax.persistence.Column;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import kodlamaio.hrms.core.utilities.annotations.UniqueEmail;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployerDto {
	
	@NotBlank(message="Şirket adı alanı boş geçilemez")
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank(message="Web adresi alanı boş geçilemez")
	@Column(name="web_address")
	private String webAddress;
	
	@Email(message = "Lütfen geçerli bir e-posta giriniz")
	@NotBlank(message = "E-posta alanı boş olamaz")
	@Column(name = "email_address")
	@UniqueEmail
	private String email;
	
	@NotBlank(message="Telefon numarası alanı boş geçilemez")
	@Column(name="phone_number")
	private String phoneNumber;
	
	@NotBlank(message = "Şifre boş geçilemez")
	@Size(min = 6, max = 20,message = "Şifreniz en az 6 en fazla 20 karakter olmalıdır")
	@Column(name = "password")
	private String password;
	
	@NotBlank(message = "Şifre boş geçilemez")
	@Transient
	@JsonProperty(access = Access.WRITE_ONLY)
	private String confirmPassword;

}
