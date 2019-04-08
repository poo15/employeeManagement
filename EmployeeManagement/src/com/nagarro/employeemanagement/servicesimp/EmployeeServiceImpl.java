package com.nagarro.employeemanagement.servicesimp;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.employeemanagement.model.Employee;
import com.nagarro.employeemanagement.services.EmployeeService;
import com.nagarro.employeemanagement.util.ReadExcelUtil;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	
	private ReadExcelUtil readCsv = new ReadExcelUtil();

	ResteasyClient client = new ResteasyClientBuilder().build();
	ResteasyWebTarget target = client.target("http://localhost:8080/employeeapi/webapi");
	
	@Override
	public List<Employee> getEmployees() { 
		
		return target.path("/employees").request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Employee>>() {});

	}
	
	@Override
	public void insertEmployees() throws JsonGenerationException, JsonMappingException, IOException {
		List<Employee> employees= readCsv.readCSV();

		//System.out.println(employees);
		  
		ObjectMapper obj = new ObjectMapper();

		HttpHeaders header = new HttpHeaders();
		header.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(obj.writeValueAsString(employees), header);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange("http://localhost:8080/employeeapi/webapi/employees", HttpMethod.POST, entity,
							ResponseEntity.class); 	
//    	
	}
	
	@Override
	public Employee getEmployee(int employeeCode) {
		return target.path("/employees/"+employeeCode).request().get(Employee.class);
	}
	@Override
	public void updateEmployee(Employee employee) {
		 target.path("/employees")
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(employee, MediaType.APPLICATION_JSON));
		
	}
}
