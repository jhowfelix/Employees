package br.com.vertigo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockitoSession;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonParseException;

import br.com.vertigo.dtos.EmployeeDTO;
import br.com.vertigo.entities.Employee;
import br.com.vertigo.repositories.EmployeeRepository;
import br.com.vertigo.services.exceptions.ErroInternoException;
import br.com.vertigo.services.exceptions.ObjectNotFoundException;

@SpringBootTest
public class EmployeeServiceTest {

	private static final String EMAIL = "jhow.wi56@gmail.com";

	private static final String STATUS = "ativo";

	private static final Date START_DATE = new Date(0);

	private static final String TYPE = "Office,";

	private static final String JOBTITLE = "Desenvolvedor";

	private static final String DEPARTAMENTO = "TI";

	private static final String ULTIMONOME = "Lima";

	private static final String NOME = "Andre";

	private static final int ID = 123;

	@InjectMocks
	private EmployeeService service;

	@Mock
	private EmployeeRepository repo;

	private EmployeeDTO empDTO;
	private Optional<Employee> optionalEmp;
	private Employee emp;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		startEmployee();

	}

	@Test
	void whenFindByIdThenReturnEmployeeInstance() throws JsonParseException, ErroInternoException {
		Mockito.when(repo.findById(Mockito.anyInt())).thenReturn(optionalEmp);
		EmployeeDTO response = service.findById(123L);

		// Assertions.assertEquals(EmployeeDTO.class, optionalEmp.getClass());
		Assertions.assertEquals(EmployeeDTO.class, response.getClass());
		Assertions.assertEquals(ID, response.getEmployeeId());
	}

	@Test
	void whenFindByIdThenReturnAnObjectNotFoundException() {
		Mockito.when(repo.findById(anyInt())).thenThrow(new ObjectNotFoundException("Not found"));
		try {
			service.findById(1L);
		} catch (Exception ex) {
			assertEquals(ObjectNotFoundException.class, ex.getClass());
		}
	}

	@Test
	void whenFindAllThenReturnAnListOfEmployee() {
		Mockito.when(repo.findAll()).thenReturn(List.of(emp));
		List<EmployeeDTO> response = service.findAll();

		assertNotNull(response);
		// Testando se o tamanho da lista é 1, pois só um objeto no List.of
		assertEquals(1, response.size());
		assertEquals(ID, response.get(0).getEmployeeId());
		
	}

//	@Test
//	void create() throws JsonParseException {
//		Mockito.when(repo.save(any())).thenReturn(emp);
//		service.insert(empDTO);
//		assertEquals(emp, null);
//
//	}

	@Test
	void update() {

	}

	@Test
	void delete() {

	}

	private void startEmployee() {
		empDTO = new EmployeeDTO(ID, NOME, ULTIMONOME, DEPARTAMENTO, JOBTITLE, TYPE, START_DATE, STATUS, EMAIL);
		optionalEmp = Optional
				.of(new Employee(ID, NOME, ULTIMONOME, DEPARTAMENTO, JOBTITLE, TYPE, START_DATE, STATUS, EMAIL));
		
		emp = new Employee(ID, NOME, ULTIMONOME, DEPARTAMENTO, JOBTITLE, TYPE, START_DATE, STATUS, EMAIL);
	}

}
