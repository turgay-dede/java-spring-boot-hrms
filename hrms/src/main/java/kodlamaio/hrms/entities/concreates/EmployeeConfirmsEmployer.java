package kodlamaio.hrms.entities.concreates;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name="employee_confirms_employers")
public class EmployeeConfirmsEmployer extends EmployeeConfirm {
	
	@Column(name="employer_id")
	private int employerId;

}
