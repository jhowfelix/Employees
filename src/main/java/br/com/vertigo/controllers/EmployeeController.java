package br.com.vertigo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vertigo.entities.Employee;
import br.com.vertigo.services.EmployeeService;

@RestController
@RequestMapping(value = "/Employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	

	@GetMapping
	public ResponseEntity<List<Employee>> findAll() {
		List<Employee> listEmployees = service.findAll();
		return ResponseEntity.ok(listEmployees);
	}

	@GetMapping(value = "/{id}")
	public Employee findById(@PathVariable("id") Integer id) {
		return service.findById(id);
	}
	
	

}
