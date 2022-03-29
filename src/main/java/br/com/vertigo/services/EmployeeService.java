package br.com.vertigo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vertigo.dtos.EmployeeDTO;
import br.com.vertigo.entities.Employee;
import br.com.vertigo.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	public List<EmployeeDTO> findAll() {
		List<Employee> findAll = repo.findAll();
		return findAll.stream().map(x -> new EmployeeDTO(x)).collect(Collectors.toList());
	}

	public EmployeeDTO findById(String id) {
		Optional<Employee> findById = repo.findById(Integer.valueOf(id));
		Employee emp = new Employee(findById.get());
		return new EmployeeDTO(emp);
	}

}
