 
package de.ebf.employee.service;

import java.util.List;

import de.ebf.employee.dto.CompanyDTO;
import de.ebf.employee.dto.CompanyDetailsDTO;
import de.ebf.employee.exception.NoRecordFoundException;

/**
 * @author Pratiyush
 *
 */
public interface ICompanyService {
	/**
	 * This method gets all the companies.
	 * @return List<CompanyDTO> - List of Companies
	 * @throws NoRecordFoundException - If No Record found in DB.
	 */
    List<CompanyDTO> getCompanies() throws NoRecordFoundException ;
    
    /**
     * This method gets details of Companies.
     * @return List<CompanyDetailsDTO> - Detailed List of Companies
     * @throws NoRecordFoundException - If No Record found in DB.
     */ 
    List<CompanyDetailsDTO> getComapniesDetailsEmployee() throws NoRecordFoundException ;
	 
}
