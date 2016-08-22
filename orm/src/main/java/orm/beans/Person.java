package orm.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author Hareesha D
 *
 */
@Entity
@Table(name="Person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//generation type is AUTO and access type is filed , since @id is on filed
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")  //column annotation is purely optional unless we want to specify other properties
	private String fname;
	
	@Column(name="last_name")
	private String lname;
	
	@Column(name="emp_id", nullable=false)
	private String empId;
	
	@Column(name="salary")
	private double salary;
	
	@Transient   //this annotation ignore the filed during persisting
	private String empType;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}
}
