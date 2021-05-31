package kodlamaio.hrms.entities.concreates;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidates")

public class Candidate extends User {
	
	@NotBlank(message="Ad boş geçilemez")
	@Size(min=2,max=20,message="Ad en az 2 karakter en fazla 20 karakter olabilir")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message="Soyad boş geçilemez")
	@Size(min=2,max=20,message="Ad en az 2 karakter en fazla 20 karakter olabilir")
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank(message="Tc kimlik numarası alanı boş geçilemez")
	@Size(min=11,max=11,message="Tc kimlik numarası 11 haneli olmalıdır")
	@Column(name="identification_number")
	//TODO:@UniqueIdentificationNumber
	private String identificationNumber;	

	@Column(name="birth_date")
	private LocalDate birthDate;

}
