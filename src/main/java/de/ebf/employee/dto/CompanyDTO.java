package de.ebf.employee.dto;

import de.ebf.employee.model.Company;

 
 
public class CompanyDTO {
	
	public CompanyDTO (Company company){
		this.setCompanyId(company.getCompanyId());
		this.setCompanyName(company.getCompanyName());
	}
	
	/**
	 * @return the companyId
	 */
	public Long getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	private Long companyId;
	
	private String companyName;
	
  
}
 