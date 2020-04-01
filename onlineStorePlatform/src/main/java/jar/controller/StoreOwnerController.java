package jar.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jar.managers.*;
import jar.user.*;

@RestController
public class StoreOwnerController extends UserController 
{
	@Autowired
	@Qualifier("Owner")
	UserManager manager = new StoreOwnerManager();

		
	@Override
	@RequestMapping(method=RequestMethod.POST , value = "/registerOwner")
	public boolean register(@RequestBody User user) throws SQLException {
		
		return (manager.addUser(user));
	}

	@Override
	@RequestMapping(method = RequestMethod.GET , value = "/onlineStore/LoginOwner")
	public User Login(@RequestBody User user) throws SQLException 
	{
		boolean isReg = manager.isRegisterd(user);
		
		if(isReg)
			return user;
		else 
			return null;
	}
	
	
	
}
