package de.ebf.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.ebf.employee.dto.CompanyDTO;
import de.ebf.employee.dto.CompanyDetailsDTO;
import de.ebf.employee.exception.NoRecordFoundException;
import de.ebf.employee.service.ICompanyService;

 /**
 * Application 
 *
 * @author Pratiyush Kumar Singh
 * @since 1.0.0
 */ 
@RestController
@RequestMapping("/api/v1")
public class CompanyController {
	
	@Autowired
	private ICompanyService companyService;
	
	
	/**
	 * This method gets all the companies.
	 * @return List<CompanyDTO> - List of Companies
	 * @throws NoRecordFoundException - If No Record found in DB.
	 */
	@GetMapping("/companies") 
	List<CompanyDTO> getCompanies() throws NoRecordFoundException {
		return companyService.getCompanies();
	}
    
    /**
     * This method gets details of Companies.
     * @return List<CompanyDetailsDTO> - Detailed List of Companies
     * @throws NoRecordFoundException - If No Record found in DB.
     */ 
	@GetMapping("/companies/details") 
    List<CompanyDetailsDTO> getComapniesDetailsEmployee() throws NoRecordFoundException {
		return companyService.getComapniesDetailsEmployee();
    } 
     
} 
 