package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concreates.Language;

public interface LanguageDao extends JpaRepository<Language, Integer>  {

}
