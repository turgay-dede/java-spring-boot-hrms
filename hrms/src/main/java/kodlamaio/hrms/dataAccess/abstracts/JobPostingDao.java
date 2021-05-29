package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concreates.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingDto;


public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
	
	@Query("select new kodlamaio.hrms.entities.dtos.JobPostingDto(id, employer.companyName, jobTitle.title, "
			+ "positionCount, createdAt, deadline) From JobPosting where status=true ")
	List<JobPostingDto> getByStatusTrue();
	
	@Query("select new kodlamaio.hrms.entities.dtos.JobPostingDto(id, employer.companyName, jobTitle.title, positionCount, "
			+ "createdAt, deadline) from JobPosting where status = true and employer.companyName=:companyName")
	List<JobPostingDto> getByCompanyNameAndStatus(@Param("companyName") String companyName);
	

}
