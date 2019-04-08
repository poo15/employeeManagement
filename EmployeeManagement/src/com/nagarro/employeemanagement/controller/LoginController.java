package com.nagarro.employeemanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.nagarro.employeemanagement.constants.Constants;
import com.nagarro.employeemanagement.model.Employee;
import com.nagarro.employeemanagement.model.User;
import com.nagarro.employeemanagement.servicesimp.EmployeeServiceImpl;
import com.nagarro.employeemanagement.servicesimp.LoginServiceImpl;

@MultipartConfig(location="/tmp", fileSizeThreshold=1024*1024, 
maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)

@Controller
public class LoginController {
	String userEmail = null;
	@Autowired
	private LoginServiceImpl loginService;
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String logedUser(Model model) {
		if(userEmail == null) {
			return "index.jsp";
		}
		model.addAttribute(Constants.EMAIL, userEmail);
		model.addAttribute(Constants.EMPLOYEES,getEmployees());
		return Constants.DASHBOARD;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Model model,@ModelAttribute("user") User user) {
		User loggedUser = loginService.login(user);
		if(loggedUser == null) {
			model.addAttribute("invalidUser",true);
			return "index.jsp";
		}
		userEmail = loggedUser.getEmail();
		model.addAttribute(Constants.EMAIL, userEmail);
		model.addAttribute(Constants.EMPLOYEES,getEmployees());
		model.addAttribute("invalidUser",false);
		return Constants.DASHBOARD;
	}
	
	private List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insertEmployee(Model model, @RequestParam("file") Part file) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("In insert service "+file.getName());
		//employeeService.insertEmployees();
		model.addAttribute(Constants.EMAIL, userEmail);
		model.addAttribute(Constants.EMPLOYEES,getEmployees());
		return "dashboard.jsp";
	}
	
	
	@RequestMapping(value="/edit{employeeCode}",method=RequestMethod.GET)
	public String getEmployee(Model model, @RequestParam String employeeCode) {
		model.addAttribute("employee",employeeService.getEmployee(Integer.parseInt(employeeCode)));
		model.addAttribute(Constants.EMAIL, userEmail);
		return "edit.jsp";
	}
	
	
	@RequestMapping("/downloadCSV")
    public void downloadCSV(HttpServletResponse response) throws IOException
    {
		 String csvFileName="Employees.csv";
         response.setContentType("text/csv");
      
      String headerKey = "Content-Disposition";
      String headerValue = String.format("attachment; filename=\"%s\"", csvFileName);
      
      response.setHeader(headerKey, headerValue);
      
      List<Employee> employees = getEmployees();
      
      ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
      
      String[] header = {"employeeCode", "employeeName", "location", "email", "dob"};
      
      csvWriter.writeHeader(header);
      
      for(Employee employee1 : employees) {
                 csvWriter.write(employee1, header);
      }
      
      csvWriter.close();
    }

	
	
	@RequestMapping(value="/editEmployee",method=RequestMethod.GET)
	public String editEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result,Model model) {
		employeeService.updateEmployee(employee);
		model.addAttribute(Constants.EMAIL, userEmail);
		model.addAttribute(Constants.EMPLOYEES,getEmployees());
		return "dashboard.jsp";
	}
}
