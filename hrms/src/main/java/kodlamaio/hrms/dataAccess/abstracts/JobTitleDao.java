package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concreates.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {

}