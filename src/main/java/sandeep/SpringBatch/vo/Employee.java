package sandeep.SpringBatch.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "EMPLOYEE")
public class Employee {

	@Column(name ="NAME")
	private String name;
	@Id
	@Column(name ="EMAIL_ADDRESS")
	private String emailAddress;
	@Column(name ="PURCHASED_PACKAGE")
	private String purchasedPackage;
}
