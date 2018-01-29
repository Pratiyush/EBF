 package de.ebf.employee.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

 
 
@Entity
public class Company {
	
	@Id
	@GeneratedValue
	@Column(name = "company_id")
	private Long companyId;
	

	@Column(name = "company_name")
	private String companyName;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "company")
	//@JoinColumn(name = "employee_id")
	private List<Employee> employeeList = new ArrayList<>();
	

	public Long getCompanyId() {
		return companyId;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
 