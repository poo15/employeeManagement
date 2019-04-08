package com.nagarro.employeemanagement.services;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.stereotype.Service;

import com.nagarro.employeemanagement.model.Employee;

/**
 * @author pooja01
 *
 */
@Service
public interface EmployeeService {

	List<Employee> getEmployees();
	void insertEmployees() throws JsonGenerationException, JsonMappingException, IOException ;
	Employee getEmployee(int employeeCode);
	
	void updateEmployee(Employee employee);
}
