package com.nagarro.employeeapi.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nagarro.employeeapi.model.User;
import com.nagarro.employeeapi.service.LoginService;
import com.nagarro.employeeapi.serviceimpl.LoginServiceImpl;

@Path("login")
public class LoginAPI {
	private LoginService loginService= new LoginServiceImpl();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User login(User user) {
		return loginService.login(user);
	}
}
