package de.ebf.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import de.ebf.employee.model.Employee;

@Component
public interface EmployeeJpaRepository extends JpaRepository<Employee,Long> {}
