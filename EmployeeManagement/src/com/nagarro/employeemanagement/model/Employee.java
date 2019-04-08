package com.nagarro.employeemanagement.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Controller;

@Controller
public class Employee {
	
	private int employeeCode;
	@NotEmpty(message="Please Enter Name")
	@Size(max=100,message="Less than 100")
	private String employeeName;
	@NotEmpty(message="Please Enter Location")
	@Size(max=100,message="Less than 100")
	private String location;
	@NotEmpty(message="Please Enter Email")
	@Size(max=100,message="Less than 100")
	private String email;
	private String dob;
	public int getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(int employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Employee [employeeCode=" + employeeCode + ", employeeName=" + employeeName + ", location=" + location
				+ ", email=" + email + ", dob=" + dob + "]";
	}	
}
