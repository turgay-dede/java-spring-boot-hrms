package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concreates.Ability;

public interface AbilityDao extends JpaRepository<Ability, Integer>  {

}
