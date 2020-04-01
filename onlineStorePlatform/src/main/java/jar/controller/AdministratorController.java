package jar.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jar.managers.AdministratorManager;
import jar.managers.UserManager;
import jar.user.User;

@RestController
public class AdministratorController extends UserController 
{
	@Autowired
	@Qualifier("Admin")
	UserManager manager = new AdministratorManager();
	
	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@RequestMapping(method = RequestMethod.GET , value = "/onlineStore/LoginAdmin")
	public User Login(@RequestBody User user) throws SQLException 
	{
		boolean isReg = manager.isRegisterd(user);
		System.out.println(user.getName()+  " " + isReg);
		if(isReg)
			return user;
		else 
			return null;
	}
	
	public List<User> listUsers (User user)
	{
		return null;
		
	}
	
	

}
