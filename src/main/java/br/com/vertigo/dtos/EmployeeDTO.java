package br.com.vertigo.dtos;

import java.sql.Date;

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

}
