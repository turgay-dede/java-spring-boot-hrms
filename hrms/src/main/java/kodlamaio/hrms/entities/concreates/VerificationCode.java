package kodlamaio.hrms.entities.concreates;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="verification_codes")
public class VerificationCode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	@Column(name="user_id")
	private int userId;
	
	@Column(name="code")
	private String code;

	@Column(name="is_verified")
	private boolean isVerified;

	@Column(name="status")
	private boolean status;

	@Column(name="created_at")
	private LocalDate createdAt;

}
