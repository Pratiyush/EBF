package de.ebf.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMP")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name = "employee_id")
	private Long id;
	@Column(name = "employee_name")
	private String name;
	@Column(name = "employee_surname")
	private String surname;
	@Column(name = "employee_address")
	private String address;
	@Column(name = "employee_salary")
	private double salary;
	@JoinColumn(name = "company_id", referencedColumnName = "company_id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Company company;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
