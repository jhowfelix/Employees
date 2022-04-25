package br.com.vertigo.services;

import java.sql.Date;
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

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		startEmployee();

	}

	@Test
	void whenFindByIdThenReturnEmployeeInstance() throws JsonParseException, ErroInternoException {
		Mockito.when(repo.findById(Mockito.anyInt())).thenReturn(optionalEmp);
		EmployeeDTO response = service.findById(123L);

		// Método falhando
		// Assertions.assertEquals(EmployeeDTO.class, optionalEmp.getClass());
		Assertions.assertEquals(EmployeeDTO.class, response.getClass());
		//Comparando id.
		Assertions.assertEquals(ID, response.getEmployeeId());
	}

	@Test
	void findAll() {

	}

	@Test
	void create() {

	}

	@Test
	void update() {

	}

	@Test
	void delete() {

	}

	private void startEmployee() {
		EmployeeDTO empDTO = new EmployeeDTO(ID, NOME, ULTIMONOME, DEPARTAMENTO, JOBTITLE, TYPE, START_DATE,
				STATUS, EMAIL);
		optionalEmp = Optional.of(new Employee(ID, NOME, ULTIMONOME, DEPARTAMENTO, JOBTITLE, TYPE, START_DATE,
				STATUS, EMAIL));
	}

}
