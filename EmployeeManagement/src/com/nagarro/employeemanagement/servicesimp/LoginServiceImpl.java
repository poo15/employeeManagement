package com.nagarro.employeemanagement.servicesimp;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.springframework.stereotype.Service;

import com.nagarro.employeemanagement.model.User;
import com.nagarro.employeemanagement.services.LoginService;
@Service("loginService")
public class LoginServiceImpl implements LoginService{

	ResteasyClient client = new ResteasyClientBuilder().build();
	ResteasyWebTarget target = client.target("http://localhost:8080/employeeapi/webapi");
	@Override
	public User login(User user) {
		Response response = target.path("/login").request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(user, MediaType.APPLICATION_JSON)); 
		return response.readEntity(User.class);
	}

}
