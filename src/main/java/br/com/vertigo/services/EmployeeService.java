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
import br.com.vertigo.services.exceptions.ErroInternoException;
import br.com.vertigo.services.exceptions.ObjectNotFoundException;
import br.com.vertigo.services.exceptions.ValidBoolean;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Transactional(readOnly = true)
	public List<EmployeeDTO> findAll() throws ErroInternoException {
		List<Employee> findAll = repo.findAll();
		return findAll.stream().map(x -> new EmployeeDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public EmployeeDTO findById(int id) throws ErroInternoException, JsonParseException {
		Optional<Employee> findById = repo.findById(id);
		findById.orElseThrow(() -> new ObjectNotFoundException("Employee not Found"));
		Employee emp = findById.get();
		return new EmployeeDTO(emp);
	}

	@Transactional
	public EmployeeDTO update(int id, EmployeeDTO empDTO) throws JsonParseException, ErroInternoException {
		EmployeeDTO emp = findById(id);
		emp.setEmployeeId(id);
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
		if (emp.getFirstName().equals("true") || emp.getFirstName().equals("false")) {
			throw new ValidBoolean("não permitido valores boleanos");
		} else if (emp.getLastName().equals("true") || emp.getLastName().equals("false")) {
			throw new ValidBoolean("não permitido valores boleanos");
		} else if (emp.getDepartment().equals("true") || emp.getDepartment().equals("false")) {
			throw new ValidBoolean("não permitido valores boleanos");
		} else if (emp.getJobTitle().equals("true") || emp.getJobTitle().equals("false")) {
			throw new ValidBoolean("não permitido valores boleanos");
		} else if (emp.getEmployeeType().equals("true") || emp.getEmployeeType().equals("false")) {
			throw new ValidBoolean("não permitido valores boleanos");
		} else if (emp.getStatus().equals("true") || emp.getStatus().equals("false")) {
			throw new ValidBoolean("não permitido valores boleanos");
		} else {
			repo.save(emp.toEntity());
		}
	}

	public void delet(int id) throws ErroInternoException, JsonParseException {
		findById(id);
		repo.deleteById(id);
	}

	public void updatePatch(int id, EmployeeDTO empDTO) throws JsonParseException, ErroInternoException {
		EmployeeDTO EmpAtt = validaNull(empDTO, findById(id));
		EmpAtt.setEmployeeId(id);
		insert(EmpAtt);
	}

	public EmployeeDTO validaNull(EmployeeDTO request, EmployeeDTO doBanco) {
		if (request.getFirstName() == null) {
			request.setFirstName(doBanco.getFirstName());
		}
		if (request.getLastName() == null) {
			request.setLastName(doBanco.getLastName());
		}
		if (request.getDepartment() == null) {
			request.setDepartment(doBanco.getDepartment());
		}
		if (request.getEmail() == null) {
			request.setEmail(doBanco.getEmail());
		}
		if (request.getJobTitle() == null) {
			request.setJobTitle(doBanco.getJobTitle());
		}
		if (request.getEmployeeType() == null) {
			request.setEmployeeType(doBanco.getEmployeeType());
		}
		if (request.getStartDate() == null) {
			request.setStartDate(doBanco.getStartDate());
		}
		if (request.getStatus() == null) {
			request.setStatus(doBanco.getStatus());
		}
		return request;
	}

}
