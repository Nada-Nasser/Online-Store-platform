package jar.controller;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jar.managers.BuyerManager;
import jar.managers.UserManager;
import jar.user.User;

@RestController
public class BuyerController extends UserController {

	@Autowired
	UserManager manager = new BuyerManager();
	
	@Override
	@RequestMapping(method=RequestMethod.POST , value = "/registerBuyer")
	public boolean register(@RequestBody User user) throws SQLException {
			manager.addUser(user);
			return true;	
	}

	@Override
	@RequestMapping(method = RequestMethod.POST , value = "/onlineStore/Login")
	public User Login(@RequestBody User user) throws SQLException 
	{
		boolean isReg = manager.isRegisterd(user);
		
		if(isReg)
			return user;
		else 
			return null;
		
	}
	
	
	@RequestMapping("/onlineStore")
	String SeyHi()
	{
		return "Hi";
	}

}
