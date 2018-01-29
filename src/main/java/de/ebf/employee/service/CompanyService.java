package de.ebf.employee.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.ebf.employee.dto.CompanyDTO;
import de.ebf.employee.dto.CompanyDetailsDTO;
import de.ebf.employee.model.Company;
import de.ebf.employee.model.Employee;
import de.ebf.employee.repository.CompanyJpaRepository;

/**
 * Application
 *
 * @author Pratiyush Kumar Singh
 * @since 1.0.0
 */
@Service
public class CompanyService implements ICompanyService {
	@Autowired
	private CompanyJpaRepository companyJpaReopsitory;

	@Override
	public List<CompanyDTO> getCompanies() {
		List<Company> companines = companyJpaReopsitory.findAll();
		return toEmployeeDTOList(companines);
	}

	private List<CompanyDTO> toEmployeeDTOList(List<Company> companines) {
		return companines.stream().map(e -> new CompanyDTO(e)).collect(Collectors.toList());

	}

	@Override
	public List<CompanyDetailsDTO> getComapniesDetailsEmployee() {
		List<Company> companines = companyJpaReopsitory.findAll();
		return toEmployeeDetailsDTOList(companines);
	}

	private List<CompanyDetailsDTO> toEmployeeDetailsDTOList(List<Company> companines) {

		return companines.stream().map(e -> new CompanyDetailsDTO(e, calculateAvg(e))).collect(Collectors.toList());

	}

	private double calculateAvg(Company company) {

		List<Employee> employees = company.getEmployeeList();
		double avgSalary = 0;
		double sum = 0;
		if (employees == null || employees.size() == 0)
			return avgSalary;

		for (Employee e : employees) {
			sum = sum + e.getSalary();
		}

		return avgSalary = sum / employees.size();

	}

}