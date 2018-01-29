package de.ebf.employee.service;

import org.fluttercode.datafactory.impl.DataFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.ebf.employee.BootApp;
import de.ebf.employee.model.Company;
import de.ebf.employee.model.Employee;
import de.ebf.employee.repository.CompanyJpaRepository;
import de.ebf.employee.repository.EmployeeJpaRepository;

/**
 * DataInitilizerService is used for initialization of Test Data in H2 DB.
 *
 * @author Pratiyush Kumar Singh
 * @since 1.0.0
 */
@Service
public class DataInitilizerService implements IDataInitilizerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BootApp.class);

	@Autowired
	private EmployeeJpaRepository employeeJpaReopsitory;

	@Autowired
	private CompanyJpaRepository companyJpaReopsitory;

	private DataFactory df;

	/**
	 * This method deletes all Employees and Companies. After deleation it inserts
	 * some Test data in Employee and Company Tables.
	 *
	 */
	@Override
	public void init() {
		LOGGER.info("Initilization Starting.");
		deleteEmployees();
		deleteCompanies();
		insertCompanies();
		LOGGER.info("Initilization Completed.");
	}

	/**
	 * This method deletes all Employee Records.
	 */
	private void deleteEmployees() {
		employeeJpaReopsitory.deleteAll();
		LOGGER.info("Deleted All Employeess Records.");
	}

	/**
	 * This method deletes all Companies Records.
	 */
	private void deleteCompanies() {
		companyJpaReopsitory.deleteAll();
		LOGGER.info("Deleted All Companies Records.");
	}

	/**
	 * This method is used to Insert Companies Record.
	 *  
	 */
	private void insertCompanies() {
		df = new DataFactory();
		for (int i = 0; i < 4; i++) {
			Company company = new Company();
			company.setCompanyName(df.getBusinessName());
			companyJpaReopsitory.save(company);
			insertEmployees(company.getCompanyId());
		}
		LOGGER.info("Inserted Employees and Company Data");

	}

	/**
	 * This method is used to Insert Employees Record based on comapanyID.
	 * 
	 * @param comapanyId
	 *            - Used to create Employee corresponding to companyID
	 */
	private void insertEmployees(long companyId) {
		for (int i = 0; i < 4; i++) {
			Company company = new Company();
			company.setCompanyId(companyId);
			Employee employee = new Employee();
			employee.setAddress(df.getAddress());
			employee.setCompany(company);
			employee.setName(df.getFirstName());
			employee.setSalary(df.getNumberBetween(10000, 20000));
			employee.setSurname(df.getLastName());
			employeeJpaReopsitory.save(employee);
		}
	}

}
