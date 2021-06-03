package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingDto {
	private int id;
	private String companyName;
	private String jobTitle;
	private String positionCount;
	private LocalDate createdAt;
	private LocalDate deadline;

}
