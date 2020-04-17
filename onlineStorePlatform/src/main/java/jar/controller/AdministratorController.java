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
import jar.user.User;

@RestController
public class AdministratorController implements UserController 
{

	@Autowired
	@Qualifier("Admin")
	AdministratorManager manager = new AdministratorManager();

	@Override
	@RequestMapping(method=RequestMethod.POST , value = "/register/Admin")
	public boolean register(@RequestBody User user) throws SQLException {
		
		return (manager.addUser(user));
	}

	@Override
	@RequestMapping(method = RequestMethod.POST , value = "/Login/Admin")
	public User Login(@RequestBody User user) throws SQLException 
	{
		boolean isReg = manager.isRegisterd(user);
		System.out.println(user.getName()+  " " + isReg);
		if(isReg)
			return user;
		else 
			return null;
	}
	
	@RequestMapping("/getUsers")
	public List<User> listUsers () throws SQLException
	{
		return(manager.getUsers());
		
	}
	
	

}
