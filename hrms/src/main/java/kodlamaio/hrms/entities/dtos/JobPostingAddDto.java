package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobPostingAddDto {
	private int id;
	private int jobTitleId;
	private int cityId;
	private int employerId;
	private String description;
	private int minSalary;
	private int maxSalary;
	private String positionCount;
	private LocalDate deadline;
	private boolean status;
	private LocalDate createdAt;

}
