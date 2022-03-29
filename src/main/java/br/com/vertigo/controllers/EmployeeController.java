package br.com.vertigo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vertigo.dtos.EmployeeDTO;
import br.com.vertigo.entities.Employee;
import br.com.vertigo.services.EmployeeService;

@RestController
@RequestMapping(value = "/Employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	

	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping(value = "/{id}")
	public EmployeeDTO findById(@PathVariable("id") String id) {
		return service.findById(id);
	}
	
	

}
