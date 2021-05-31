package kodlamaio.hrms.entities.concreates;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.core.utilities.annotations.UniqueJobTitle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_titles")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostings"})
public class JobTitle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;	
	
	@NotBlank(message="Başlık alanı boş geçilemez")
	@UniqueJobTitle
	@Column(name="title")
	private String title;	

	@JsonIgnore
	@Column(name="status")
	private boolean status;	
	
	@JsonIgnore
	@Column(name="created_at")
	private LocalDate createdAt;
	
	@OneToMany(mappedBy = "jobTitle")
	private List<JobPosting> jobPostings;

}