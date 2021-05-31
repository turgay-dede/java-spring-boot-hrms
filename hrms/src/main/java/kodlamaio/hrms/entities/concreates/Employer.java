package kodlamaio.hrms.entities.concreates;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostings"})
public class Employer extends User {
	
	@NotBlank(message="Şirket adı alanı boş geçilemez")
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank(message="Web adresi alanı boş geçilemez")
	@Column(name="web_address")
	//TODO:web sitesi ile aynı domaine sahip e-posta kontrolü
	private String webAddress;
	
	@NotBlank(message="Telefon numarası alanı boş geçilemez")
	@Column(name="phone_number")
	private String phoneNumber;
	
	@OneToMany(mappedBy = "employer")
    private List<JobPosting> jobPostings;
	
	

}
