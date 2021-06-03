package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concreates.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer>  {
	@Query("Select j From JobExperience j JOIN j.resume r JOIN r.candidate c where c.id=:candidateId ORDER BY j.finishedAt DESC")
	List<JobExperience> getAllJobExByCandidateIdSortedFinishedAt(int candidateId);

}
