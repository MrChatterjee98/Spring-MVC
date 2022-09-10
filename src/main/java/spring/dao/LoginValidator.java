package spring.dao;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.model.LoginModel;

@Repository
@Transactional
public class LoginValidator {
	Session session;
	@Autowired
	SessionFactory sessionFactory;
	
	public LoginModel isValidUser(String username,String passsword) {
		session= sessionFactory.openSession();
		LoginModel loginObj;
		loginObj = session.find(LoginModel.class,username);
		return loginObj;
		
	}
	
	public void regristartion(LoginModel model) {
		
		session = sessionFactory.getCurrentSession();
		session.save(model);
		
		
		
	}
}
