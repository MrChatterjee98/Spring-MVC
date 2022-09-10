package spring.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.dao.LoginValidator;
import spring.model.LoginModel;

@Service
public class LoginService {

	
	
	@Autowired
	LoginValidator loginValidator;
	//private final String salt = BCrypt.gensalt(10);
	
	
	
	
	public boolean loginValidation(String username,String Password) {
		
		LoginModel user = loginValidator.isValidUser(username, Password);
		
		if(user == null)
			return false;
		
		return BCrypt.checkpw(Password, user.getPassword());
	}
	
	public boolean registration(LoginModel login) {
		try {
			login.setPassword(BCrypt.hashpw(login.getPassword(), BCrypt.gensalt()));
			loginValidator.regristartion(login);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}
}
