package kodlamaio.hrms.entities.concreates;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employees")
public class Employee extends User {
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

}
