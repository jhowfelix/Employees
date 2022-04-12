package br.com.vertigo.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;

import br.com.vertigo.dtos.EmployeeDTO;
import br.com.vertigo.services.EmployeeService;
import br.com.vertigo.services.exceptions.ErroInternoException;

@RestController
@RequestMapping(value = "/Employees")
@CrossOrigin(origins = "*")
@Validated
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping
	public ResponseEntity<EmployeeDTO> insert(@Valid @RequestBody EmployeeDTO empDTO) throws JsonParseException {
		service.insert(empDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(empDTO.getEmployeeId())
				.toUri();
		return ResponseEntity.created(uri).body(empDTO);
	}

	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> findById(@PathVariable("id") @Min(1) @Max(2147483647) long id)
			throws JsonParseException, ErroInternoException {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> update(@PathVariable("id") @Min(1) @Max(2147483647) Long id,
			@RequestBody @Valid EmployeeDTO empDTO) throws JsonParseException, ErroInternoException {
		EmployeeDTO update = service.update(id, empDTO);
		return ResponseEntity.ok(update);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") @Min(1) @Max(2147483647) Long id)
			throws JsonParseException, ErroInternoException {
		service.delet(id);
		return ResponseEntity.noContent().build();
	}

	@PatchMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> updatePath(@PathVariable("id") @Min(1) @Max(2147483647) Long id,
			@RequestBody @Valid EmployeeDTO empDTO) throws JsonParseException, ErroInternoException {
		service.updatePatch(id, empDTO);
		return ResponseEntity.ok(empDTO);

	}

}
