package br.com.vertigo.dtos;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.vertigo.entities.Employee;

public class EmployeeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String department;
	private String jobTitle;
	private String employeeType;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date startDate;
	private String status;
	private String email;

	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(Integer employeeId, String firstName, String lastName, String department, String jobTitle,
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

	public EmployeeDTO(Employee emp) {
		employeeId = emp.getEmployeeId();
		firstName = emp.getFirstName();
		lastName = emp.getLastName();
		department = emp.getDepartment();
		jobTitle = emp.getJobTitle();
		employeeType = emp.getEmployeeType();
		startDate = emp.getStartDate();
		status = emp.getStatus();
		email = emp.getEmail();
	}

	public Employee toEntity() {
		return new Employee(this.employeeId, this.firstName, this.lastName, this.department, this.jobTitle,
				this.employeeType, this.startDate, this.status, this.email);
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

	@Override
	public String toString() {
		return "EmployeeDTO [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", department=" + department + ", jobTitle=" + jobTitle + ", employeeType=" + employeeType
				+ ", startDate=" + startDate + ", status=" + status + ", email=" + email + "]";
	}

}
