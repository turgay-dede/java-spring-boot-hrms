package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concreates.EmployeeConfirmsEmployer;

public interface EmployeeConfirmsEmployerDao extends JpaRepository<EmployeeConfirmsEmployer, Integer> {
	EmployeeConfirmsEmployer findByEmployerId(int employerId);
}
