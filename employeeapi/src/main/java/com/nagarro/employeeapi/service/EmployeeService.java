package com.nagarro.employeeapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.employeeapi.model.Employee;

/**
 * @author pooja01
 *
 */
@Service
public interface EmployeeService {

	List<Employee> getEmployees();
	
	Employee getEmployee(int employeeCode);
	
	void insertEmployees(List<Employee> employees);
	
	void updateEmployee(Employee employee);
}
