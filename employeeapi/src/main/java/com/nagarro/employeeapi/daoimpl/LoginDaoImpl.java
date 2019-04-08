package com.nagarro.employeeapi.daoimpl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import com.nagarro.employeeapi.dao.LoginDAO;
import com.nagarro.employeeapi.model.User;
import com.nagarro.employeeapi.util.HibernateUtil;

public class LoginDaoImpl implements LoginDAO{
	 Session session=null;
	 final Logger logger = Logger.getLogger("myLogger");
	@Override
	public User login(User user) {
		logger.info("In Dao Layer");
		createSession();
		final Query<User> query = session.createQuery("FROM User WHERE email= '"+user.getEmail()+"' AND password= '"+user.getPassword()+"'",User.class);
		return query.uniqueResult();
	}
	
	public void createSession() {
		try{
			session = HibernateUtil.getSessionFactory().openSession();	
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

}
