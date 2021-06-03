package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concreates.Resume;
import kodlamaio.hrms.entities.dtos.ResumeDto;

public interface ResumeDao extends JpaRepository<Resume, Integer> {	
	
	@Query("Select new kodlamaio.hrms.entities.dtos.ResumeDto"
			+ "(r.id,s.schoolName,s.department,l.languageName,r.photoUrl,r.githubLink,r.linkedLink,r.description) "
			+ "From Resume r Inner Join r.schools s Inner Join r.languages l where r.id = :id")
	ResumeDto getResumeDetails(int id);
	
	List<Resume> findByCandidate_Id(int id);
	
	
	@Query("Select r From Resume r ORDER BY createdAt DESC")
	List<Resume> getAllResumeSortedByCreatedAt();
	
}
