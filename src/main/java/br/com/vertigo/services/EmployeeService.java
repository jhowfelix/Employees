package br.com.vertigo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vertigo.entities.Employee;
import br.com.vertigo.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	public List<Employee> findAll() {
		return repo.findAll();
	}
	
	public Employee findById(Integer id) {
		Optional<Employee> findById = repo.findById(id);
		Employee emp = new Employee(findById.get());
		return emp;
	}
	
	
}
