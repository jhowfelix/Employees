package br.com.vertigo.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "employees")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer id;

	@Column(name = "first_name", length = 45)
	private String firstName;

	@Column(name = "last_name", length = 45)
	private String lastName;

	@Column(name = "department", length = 45)
	private String department;

	@Column(name = "job_title", length = 45)
	private String jobTitle;

	@Column(name = "employee_type", length = 45)
	private String employeeType;

	@Column(name = "start_date", length = 45)
	private Date startDate;

	@Column(name = "status", length = 45)
	private String status;

	@Column(name = "email", length = 45)
	private String email;

	public Employee() {
		super();
	}

	public Employee(Integer id, String firstName, String lastName, String department, String jobTitle,
			String employeeType, Date startDate, String status, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.jobTitle = jobTitle;
		this.employeeType = employeeType;
		this.startDate = startDate;
		this.status = status;
		this.email = email;
	}

	public Employee(Employee emp) {
		id = emp.getId();
		firstName = emp.getFirstName();
		lastName = emp.getFirstName();
		department = emp.getDepartment();
		jobTitle = emp.getJobTitle();
		employeeType = emp.getEmployeeType();
		startDate = emp.getStartDate();
		status = emp.getStatus();
		email = emp.getEmail();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

}
