package com.nagarro.employeeapi.serviceimpl;

import com.nagarro.employeeapi.dao.LoginDAO;
import com.nagarro.employeeapi.daoimpl.LoginDaoImpl;
import com.nagarro.employeeapi.model.User;
import com.nagarro.employeeapi.service.LoginService;

public class LoginServiceImpl implements LoginService{

	private LoginDAO loginDao	= new LoginDaoImpl();
	
	@Override
	public User login(User user) {
		System.out.println("service");
		return loginDao.login(user);
	}

}
