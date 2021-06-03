package kodlamaio.hrms.entities.concreates;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="resumes")

public class Resume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;	
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Candidate.class)
	@JoinColumn(name ="candidate_id",referencedColumnName ="id",nullable = false)
	private Candidate candidate;
	
	@Column(name="photo_url")
	private String photoUrl;
	
	@Column(name="github_link")
	private String githubLink;
	
	@Column(name="linked_link")
	private String linkedLink;
	
	@Column(name="description")
	private String description;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name = "created_at",updatable = false)
	private LocalDate createdAt;
	
	@Column(name="updated_at")
	private LocalDate updatedAt;
	
	
	
	@OneToMany(mappedBy ="resume" )
	private List<School> schools;
	
	@OneToMany(mappedBy ="resume" )
	private List<Language> languages;
	
	@OneToMany(mappedBy ="resume" )
	private List<Ability> abilities;
	
	@OneToMany(mappedBy ="resume" )
	private List<JobExperience> jobExperiences;
	
	
	

}
