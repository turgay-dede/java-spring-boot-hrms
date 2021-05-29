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

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="job_postings")
public class JobPosting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="salary")
	private String salary;
	
	@Column(name="position_count")
	private String positionCount;
	
	@Column(name="deadline")
	private LocalDate deadline;
	
	@Column(name="status")
	private boolean status;
	
	public JobPosting(String description, String salary, String positionCount, LocalDate deadline, boolean status,
			LocalDate createdAt, JobTitle jobTitle, City city, Employer employer) {
		super();
		this.description = description;
		this.salary = salary;
		this.positionCount = positionCount;
		this.deadline = deadline;
		this.status = status;
		this.createdAt = createdAt;
		this.jobTitle = jobTitle;
		this.city = city;
		this.employer = employer;
	}

	@Column(name="created_at")
	private LocalDate createdAt;
	

	@ManyToOne
	@JoinColumn(name="job_title_id")
	private JobTitle jobTitle;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	 @ManyToOne
	 @JoinColumn(name = "employer_id")
	 private Employer employer;

}
