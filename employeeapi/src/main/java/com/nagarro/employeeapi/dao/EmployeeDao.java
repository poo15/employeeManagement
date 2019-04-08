package com.nagarro.employeeapi.dao;

import java.util.List;

import com.nagarro.employeeapi.model.Employee;

public interface EmployeeDao {
	List<Employee> getEmployees();
	void insertEmployees(List<Employee> employees);

	Employee getEmployee(int employeeCode);
	void updateEmployee(Employee employee);
}
