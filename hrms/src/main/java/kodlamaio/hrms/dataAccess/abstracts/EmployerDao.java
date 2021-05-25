package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concreates.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

}
