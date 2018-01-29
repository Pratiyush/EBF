package de.ebf.employee.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.ebf.employee.dto.EmployeeDTO;
import de.ebf.employee.exception.NoRecordFoundException;
import de.ebf.employee.model.Company;
import de.ebf.employee.model.Employee;
import de.ebf.employee.repository.EmployeeJpaRepository;

/**
 * EmployeeService helps in Employee Operations like - Create Employee, Update Employee, Delete Employee and Get Employees.
 *
 * @author Pratiyush Kumar Singh
 * @since 1.0.0
 */
@Service
public class EmployeeService implements IEmployeeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeJpaRepository employeeJpaReopsitory;

	/**
	 * This method gets all the employees for all companies.
	 *
	 * @return List<EmployeeDTO> - List of Employees
	 * @throws NoRecordFoundException
	 *             - - If No Record found in DB.
	 */
	@Override
	public List<EmployeeDTO> getAllEmployees() throws NoRecordFoundException {
		List<Employee> employeeList = employeeJpaReopsitory.findAll();

		if (employeeList == null)
			throw new NoRecordFoundException("No Employee Records Found.");

		return toEmployeeDTOList(employeeList);
	}

	/**
	 * This method converts employee List to Employee DTO List.
	 *
	 * @return List<EmployeeDTO> - List of Employees
	 */
	private List<EmployeeDTO> toEmployeeDTOList(List<Employee> employeeList) {
		return employeeList.stream().map(e -> new EmployeeDTO(e)).collect(Collectors.toList());

	}

	/**
	 * This method gets an employee based on Employee ID.
	 *
	 * @return List<EmployeeDTO> - List of Employees
	 * @throws NoRecordFoundException
	 *             -- If No Employee Record found in DB.
	 */
	@Override
	public List<EmployeeDTO> getAllEmployees(long companyId) throws NoRecordFoundException {
		List<Employee> employeeList = employeeJpaReopsitory.findAll();

		if (employeeList == null || employeeList.size() == 0) {
			LOGGER.info("No Employee Records Found.");
			throw new NoRecordFoundException("No Employee Records Found.");

		}

		return toEmployeeDTOList(employeeList);
	}

	/**
	 * This method gets an employee based on company ID and Employee ID.
	 *
	 * @return List<EmployeeDTO> - Details of an Employee
	 * @throws NoRecordFoundException
	 *             - If No Record found in DB.
	 */
	@Override
	public EmployeeDTO getEmployee(long companyId, long employeeId) throws NoRecordFoundException {
		// Id should not be null - IllegalArgumentException - if id is null
		Employee employee = employeeJpaReopsitory.findOne(employeeId);
		return new EmployeeDTO(employee);
	}

	/**
	 * This method create an employee.
	 * 
	 * @param companyId
	 *            - Company ID
	 * @param employee
	 *            - This object contains employee details.
	 * @throws NoRecordFoundException
	 *             - If No Record found in DB.
	 */
	@Override
	public void createEmployee(long companyId, Employee employee) {
		Company company = new Company();
		company.setCompanyId(companyId);
		employee.setCompany(company);

		employeeJpaReopsitory.save(employee);
 
	}

	/**
	 * This method updates an employee based on Employee ID.
	 * 
	 * @param companyId
	 *            - Company ID
	 * @param employeeId
	 *            - Employee ID
	 * @throws NoRecordFoundException
	 *             - If No Record found in DB.
	 */
	@Override
	public void updateEmployee(long companyId, long employeeId, Employee employee)
			throws NoRecordFoundException {
		employee.setId(employeeId);

		Company company = new Company();
		company.setCompanyId(companyId);
		employee.setCompany(company);

		employeeJpaReopsitory.save(employee);
	}

	/**
	 * This method deletes an employee based on Employee ID.
	 * 
	 * @param companyId
	 *            - Company ID
	 * @param employeeId
	 *            - Employee ID
	 * @throws NoRecordFoundException
	 *             - If No Record found in DB.
	 */
	@Override
	public void deleteEmployee(long companyId, long employeeId) throws NoRecordFoundException {
		employeeJpaReopsitory.delete(employeeId);
	}
}
