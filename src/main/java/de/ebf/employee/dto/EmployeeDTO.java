package de.ebf.employee.dto;

import de.ebf.employee.model.Employee;

 

public class EmployeeDTO {
	private Long id;
	private String name;
	private String surname;
	private String address;
	private Long salary;
	
	
	public EmployeeDTO(Employee employee){
		this.setId(employee.getId());
		this.setName(employee.getName());
		this.setSurname(employee.getSurname());
		this.setAddress(employee.getAddress());
		this.setSalary(employee.getId());
	}


	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}


	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}


	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * @return the salary
	 */
	public Long getSalary() {
		return salary;
	}


	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Long salary) {
		this.salary = salary;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	} 
}
