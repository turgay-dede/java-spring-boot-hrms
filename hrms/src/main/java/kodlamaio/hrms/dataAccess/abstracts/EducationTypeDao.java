package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concreates.EducationType;

public interface EducationTypeDao extends JpaRepository<EducationType, Integer>  {

}
