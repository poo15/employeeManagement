package com.nagarro.employeeapi.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.employeeapi.daoimpl.EmployeeDaoImp;
import com.nagarro.employeeapi.model.Employee;
import com.nagarro.employeeapi.service.EmployeeService;

@Component("EmployeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService{
	
	
	private EmployeeDaoImp employeeDao = new EmployeeDaoImp();
	
	@Override
	public List<Employee> getEmployees() { 
		
		return employeeDao.getEmployees();

	}

	@Override
	public void insertEmployees(List<Employee> employees) {
		 employeeDao.insertEmployees(employees);
	}

	@Override
	public void updateEmployee(Employee employee) {
		 employeeDao.updateEmployee(employee);
	}

	@Override
	public Employee getEmployee(int employeeCode) {
		
		return employeeDao.getEmployee(employeeCode);
	}


}
