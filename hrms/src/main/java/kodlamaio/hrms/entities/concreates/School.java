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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="resume_schools")
public class School {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="school_name")
	private String schoolName;
	
	@Column(name="department")
	private String department;
	
	@Column(name="started_at")
	private LocalDate startedAt;
	
	@Column(name="finished_at")
	private LocalDate finishedAt;
	
	@Column(name = "created_at",updatable = false)
	private LocalDate createdAt;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Resume.class)
	@JoinColumn(name="resume_id")
	private Resume resume;
	

	@ManyToOne(targetEntity = EducationType.class)
	@JoinColumn(name="education_type_id",referencedColumnName = "id",nullable = false)
	private EducationType educationType;

}
