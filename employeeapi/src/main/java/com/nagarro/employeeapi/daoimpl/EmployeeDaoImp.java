package com.nagarro.employeeapi.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

import com.nagarro.employeeapi.dao.EmployeeDao;
import com.nagarro.employeeapi.model.Employee;
import com.nagarro.employeeapi.util.HibernateUtil;

@Repository
public class EmployeeDaoImp implements EmployeeDao {
	Session session = null;// must be initialized
	final Logger logger = Logger.getLogger("myLogger");

	@Override
	public List<Employee> getEmployees() {
		createSession();
		final Query<Employee> query = session.createQuery("FROM Employee", Employee.class);
		return query.getResultList();
	}

	public void createSession() {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void insertEmployees(List<Employee> employees) {
		createSession();
		session.beginTransaction();
		employees.forEach(employee -> {
			session.persist(employee);
		});
		session.getTransaction().commit();
	}

	@Override
	public void updateEmployee(Employee employee) {
		createSession();
		session.beginTransaction();
		// can we update whole object in table
		String hql = "Update Employee set employeeName='" + employee.getEmployeeName() + "' , location='"
				+ employee.getLocation() + "' , dob='" + employee.getDob() + "' , email='" + employee.getEmail()
				+ "' where employeeCode=" + employee.getEmployeeCode();
		final Query query = session.createQuery(hql);
		query.executeUpdate();
		session.getTransaction().commit();

	}

	@Override
	public Employee getEmployee(int employeeCode) {
		createSession();
		session.beginTransaction();

		return session.find(Employee.class, employeeCode);
	}
}
