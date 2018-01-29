package de.ebf.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import de.ebf.employee.model.Company;

@Component
public interface CompanyJpaRepository extends JpaRepository<Company,Long> {}
 