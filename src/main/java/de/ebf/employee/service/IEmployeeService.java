/**
 * 
 */
package de.ebf.employee.service;

import java.util.List;

import de.ebf.employee.dto.EmployeeDTO;
import de.ebf.employee.exception.NoRecordFoundException;
import de.ebf.employee.model.Employee;

/**
 * 
 * This interface handles the employees operations.
 * 
 * @author Pratiyush Kumar Singh
 *
 */
public interface IEmployeeService {
	
	 /**
     * This method create an employee.
	 * @param companyId -  Company ID
     * @param employee - This object contains employee details.
     * @throws NoRecordFoundException - If No Record found in DB.
     */
	void createEmployee(long companyId, Employee employee) throws NoRecordFoundException;
    
    /**
     * This method updates an employee based on Employee ID.
	 * @param companyId -  Company ID
	 * @param employeeId -  Employee ID
     * @throws NoRecordFoundException - If No Record found in DB.
     */
    void updateEmployee(long companyId,long employeeId, Employee employee) throws NoRecordFoundException;
    
    /**
     * This method deletes an employee based on Employee ID.
	 * @param companyId -  Company ID
	 * @param employeeId -  Employee ID
     * @throws NoRecordFoundException - If No Record found in DB.
     */
    void deleteEmployee(long companyId, long employeeId) throws NoRecordFoundException;
    
    /**
	 * This method gets an employee based on company ID and Employee ID.
	 * @param companyId -  Company ID
	 * @param employeeId -  Employee ID
	 * @return List<EmployeeDTO> - Details of an Employee
	 * @throws NoRecordFoundException- If No Record found in DB.
	 */
    EmployeeDTO getEmployee(long companyId, long employeeId) throws NoRecordFoundException;
    
    
	/**
     * This method gets an employee based on Employee ID.
     * @param companyId -  Company ID
     * @return List<EmployeeDTO> - List of Employees
     * @throws NoRecordFoundException -- If No Employee Record found in DB.
     */
    List<EmployeeDTO> getAllEmployees(long companyId) throws NoRecordFoundException;
    
    /**
     * This method gets all the employees for all companies.
     *
     * @return List<EmployeeDTO> - List of Employees
     * @throws NoRecordFoundException - - If No Record found in DB.
     */
    List<EmployeeDTO> getAllEmployees() throws NoRecordFoundException;
   
	
}
