package br.com.vertigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vertigo.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
