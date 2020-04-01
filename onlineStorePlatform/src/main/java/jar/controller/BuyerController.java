package jar.controller;

import java.sql.SQLException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jar.user.User;

@RestController
public class BuyerController extends UserController {

	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		return null;
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
