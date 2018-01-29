package de.ebf.employee.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.ebf.employee.dto.EmployeeDTO;
import de.ebf.employee.exception.NoRecordFoundException;
import de.ebf.employee.model.Employee;
import de.ebf.employee.service.IEmployeeService;

/**
 * EmployeeController Class CURD operations on Employee records.
 *
 * @author Pratiyush Kumar Singh
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/companies")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	/**
	 * This method create an employee.
	 *
	 * @param companyId
	 *            - Employee are inserted to corresponding company.
	 * @param employee
	 *            - Employee Data Transfer Object.
	 * @return String - Message of Employee Insertion.
	 * @throws NoRecordFoundException 
	 */
	@PostMapping("/{companyId}/employees") // TODO: May Be Company ID not required
	String createEmployee(@PathVariable final long companyId, @RequestBody final Employee employee) throws NoRecordFoundException {
		employeeService.createEmployee(companyId, employee);

		// TODO: Create Response Body for Successful and Failed.
		return "Employee Record Created for " + employee.getName();
	}

	/**
	 * This method updates an employee based on Employee ID and CompanyID.
	 *
	 * @param employeeId
	 *            - identification of an employee
	 * @return employee - Employee Data Transfer Object.
	 * @return String - Message of Employee Updation.
	 * @throws NoRecordFoundException
	 *             - When there is no record is found corresponding to EmployeeId
	 *             and CompanyID.
	 */
	@PutMapping("/{companyId}/employees/{employeeId}")
	String updateEmployee(@PathVariable final long companyId, @PathVariable final long employeeId,
			@RequestBody final Employee employee) throws NoRecordFoundException {
		employeeService.updateEmployee(companyId, employeeId, employee);

		// TODO: Create Response Body for Successful and Failed.
		return "Employee Record Updated for " + employee.getName();
	}

	/**
	 * This method gets an employee based on Employee ID.
	 *
	 * @param employeeId
	 *            - identification of an employee
	 * @return employeeDTO - Employee Data Transfer Object.
	 * @throws EntityNotFoundException
	 *             - if employee doesn't exist with employeeId
	 */
	@DeleteMapping("/{companyId}/employees/{employeeId}")
	String deleteEmployee(@PathVariable final long companyId, @PathVariable final long employeeId)
			throws NoRecordFoundException {
		employeeService.deleteEmployee(companyId, employeeId);

		// TODO: Create Response Body for Successful and Failed.
		return "Employee Record Deleted for Employee ID." + employeeId;

	}

	/**
	 * This method gets an employee based on company ID and Employee ID.
	 *
	 * @return List<EmployeeDTO> - Details of an Employee
	 * @throws NoRecordFoundException
	 *             - If No Record found in DB.
	 */
	@GetMapping("/{companyId}/employees/{employeeId}") 
	EmployeeDTO getEmployee(@PathVariable final long companyId, @PathVariable final long employeeId) throws NoRecordFoundException {
		return employeeService.getEmployee(companyId, employeeId);
	}

	/**
	 * This method gets all the employees based on companyId.
	 *
	 * @return List<EmployeeDTO> - List of Employees
	 * @throws NoRecordFoundException
	 *             - If No Record found in DB.
	 */
	@GetMapping("/{companyId}/employees")
	List<EmployeeDTO> getAllEmployees(@PathVariable final long companyId) throws NoRecordFoundException {
		return employeeService.getAllEmployees(companyId);
	}

	/**
	 * This method gets all the employees for all companies.
	 *
	 * @return List<EmployeeDTO> - List of Employees
	 * @throws NoRecordFoundException
	 *             - If No Record found in DB.
	 */
	@GetMapping("/employees")
	List<EmployeeDTO> getAllEmployees() throws NoRecordFoundException {
		return employeeService.getAllEmployees();
	}

}
