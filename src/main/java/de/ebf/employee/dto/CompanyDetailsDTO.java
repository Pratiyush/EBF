package de.ebf.employee.dto;

import de.ebf.employee.model.Company;

 
 
public class CompanyDetailsDTO {
	
	public CompanyDetailsDTO (Company company,double avgSalary ){
		this.setCompanyId(company.getCompanyId());
		this.setCompanyName(company.getCompanyName());
		this.setEmployeeCount(company.getEmployeeList().size());
		this.setAvgSalary(avgSalary);
	}
	
	
	private Long companyId;
	
	private String companyName;
	
	private int employeeCount;
	
	private double  avgSalary;
 
	public Long getCompanyId() {
		return companyId;
	}

	public int getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}

	public double  getAvgSalary() {
		return avgSalary;
	}

	public void setAvgSalary(double  avgSalary) {
		this.avgSalary = avgSalary;
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
}
 