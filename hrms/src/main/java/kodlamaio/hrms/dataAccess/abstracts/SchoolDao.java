package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concreates.School;

public interface SchoolDao extends JpaRepository<School, Integer>  {
	
	@Query("Select s From School s JOIN s.resume r JOIN r.candidate c where c.id=:candidateId ORDER BY s.finishedAt DESC")
	List<School> getAllSchoolByCandidateIdSortedFinishedAt(int candidateId);
	
	
}
