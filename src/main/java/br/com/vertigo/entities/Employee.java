package br.com.vertigo.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "employees")
@Entity
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	@Column(name = "employee_id")
	private Integer employeeId;

	@Size(min = 1, max = 55)
	@Column(name = "first_name")
	private String firstName;

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@Size(min = 1, max = 55)
	@Column(name = "last_name")
	private String lastName;

	@Size(min = 1, max = 55)
	@Column(name = "department")
	private String department;

	@Size(min = 1, max = 55)
	@Column(name = "job_title")
	private String jobTitle;

	@Size(min = 1, max = 55)
	@Column(name = "employee_type")
	private String employeeType;

	@Column(name = "start_date")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date startDate;

	@Size(min = 1, max = 55)
	@Column(name = "status")
	private String status;

	@Email
	@Size(min = 1, max = 55)
	@Column(name = "email")
	private String email;

	public Employee() {
		super();
	}

	public Employee(Integer employeeId, String firstName, String lastName, String department, String jobTitle,
			String employeeType, Date startDate, String status, String email) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.jobTitle = jobTitle;
		this.employeeType = employeeType;
		this.startDate = startDate;
		this.status = status;
		this.email = email;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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

}
