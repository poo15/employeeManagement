package com.nagarro.employeeapi.resources;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;

import com.nagarro.employeeapi.model.Employee;
import com.nagarro.employeeapi.service.EmployeeService;
import com.nagarro.employeeapi.serviceimpl.EmployeeServiceImpl;

@Path("employees")
public class EmployeeAPI {

//		@Resource(name="EmployeeServiceImpl")
//		private EmployeeServiceImpl employeeService;
		
		private EmployeeService employeeService = new EmployeeServiceImpl();
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Employee> getEmployees() {
			return employeeService.getEmployees();
		}
		
		
		@GET
		@Path("/{employeeCode}")
		@Produces(MediaType.APPLICATION_JSON)
		//employeeCode should be in string
		public Employee getEmployee(@PathParam("employeeCode") int employeeCode) {
			return employeeService.getEmployee(employeeCode);
		}
		
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public void addEmployees(List<Employee> employees){
			employeeService.insertEmployees(employees);
		}
		
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		public void updateEmployee(Employee employee) {
			employeeService.updateEmployee(employee);
		}
}
