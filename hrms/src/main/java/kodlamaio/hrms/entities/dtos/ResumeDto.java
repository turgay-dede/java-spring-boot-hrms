package kodlamaio.hrms.entities.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {
	private int id;
	private String schoolType;
	private String schoolName;
	private List<String> department;
	private List<String> companyName;
	private List<String> position;
	private List<String> abilityName;
	private String languageName;
	private List<Character> languageLevel;
	private String photoUrl;
	private String githubLink;
	private String linkedLink;
	private String description;

}
