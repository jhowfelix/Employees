package br.com.vertigo.dtos;

import java.sql.Date;

import br.com.vertigo.entities.Employee;

public class EmployeeDTO {

	private Integer id;
	private String firstName;
	private String lastName;
	private String department;
	private String jobTitle;
	private String employeeType;
	private Date startDate;
	private String status;
	private String email;

	public EmployeeDTO(Integer id, String firstName, String lastName, String department, String jobTitle,
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
	
	public EmployeeDTO(Employee emp) {
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
	
	public Employee toEntity() {
		return new Employee(this.id, this.firstName, this.lastName, 
				this.department, this.jobTitle,
				this.employeeType, this.startDate,
				this.status, this.email);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
