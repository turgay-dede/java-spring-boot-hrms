package kodlamaio.hrms.entities.concreates;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_postings")
public class JobPosting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotBlank(message = "İş tanımı yapmak zorunludur")
	@Column(name = "description")
	private String description;

	@Column(name = "min_salary")
	private int minSalary;

	@Column(name = "max_salary")
	private int maxSalary;

	@NotBlank(message = "Açık pozisyon alanı zorunludur")
	@Column(name = "position_count")
	private String positionCount;

	@Column(name = "deadline")
	private LocalDate deadline;

	@Column(name = "status")
	private boolean status;

	@Column(name = "created_at",updatable = false)
	private LocalDate createdAt;

	@NotBlank(message = "İş pozisyonu alanı zorunludur")
	@ManyToOne
	@JoinColumn(name = "job_title_id")
	private JobTitle jobTitle;

	@NotBlank(message = "Şehir seçme alanı zorunludur")
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;	

}
