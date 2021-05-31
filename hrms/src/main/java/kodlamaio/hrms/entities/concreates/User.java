package kodlamaio.hrms.entities.concreates;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import kodlamaio.hrms.core.utilities.annotations.UniqueEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	@Email(message = "Lütfen geçerli bir e-posta giriniz")
	@NotBlank(message = "E-posta alanı boş olamaz")
	@Column(name = "email_address")
	//TODO:@UniqueEmail
	@UniqueEmail
	private String email;

	@NotBlank(message = "Şifre boş geçilemez")
	@Size(min = 6, max = 20,message = "Şifreniz en az 6 en fazla 20 karakter olmalıdır")
	@Column(name = "password")
	private String password;

	@NotBlank(message = "Şifre boş geçilemez")
	@Transient
	@JsonProperty(access = Access.WRITE_ONLY)
	private String confirmPassword;

	@JsonIgnore
	@Column(name = "status")
	private boolean status;
	
	@JsonIgnore
	@Column(name = "created_at")
	private LocalDate createdAt;

}
