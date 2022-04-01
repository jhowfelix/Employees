package br.com.vertigo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;

import br.com.vertigo.dtos.EmployeeDTO;
import br.com.vertigo.entities.Employee;
import br.com.vertigo.repositories.EmployeeRepository;
import br.com.vertigo.services.exceptions.ObjectNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Transactional(readOnly = true)
	public List<EmployeeDTO> findAll() {
		List<Employee> findAll = repo.findAll();
		return findAll.stream().map(x -> new EmployeeDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public EmployeeDTO findById(int id) {
		Optional<Employee> findById = repo.findById(id);
		findById.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		Employee emp = findById.get();
		return new EmployeeDTO(emp);
	}

	@Transactional
	public EmployeeDTO update(int id, EmployeeDTO empDTO) throws JsonParseException {
		EmployeeDTO emp = findById(id);
		emp.setId(id);
		emp.setFirstName(empDTO.getFirstName());
		emp.setLastName(empDTO.getLastName());
		emp.setDepartment(empDTO.getDepartment());
		emp.setJobTitle(empDTO.getJobTitle());
		emp.setEmployeeType(empDTO.getEmployeeType());
		emp.setStartDate(empDTO.getStartDate());
		emp.setStatus(empDTO.getStatus());
		emp.setEmail(empDTO.getEmail());
		repo.save(emp.toEntity());
		return emp;

	}

	@Transactional
	public void insert(EmployeeDTO emp) throws JsonParseException {
		repo.save(emp.toEntity());
	}

	public void delet(int id) {
		findById(id);
		repo.deleteById(id);
	}

}
