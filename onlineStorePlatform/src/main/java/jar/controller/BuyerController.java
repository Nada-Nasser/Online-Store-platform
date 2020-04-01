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
	UserManager m = new BuyerManager();
	
	@Override
	@RequestMapping(method=RequestMethod.POST , value = "/registerBuyer")
	public boolean register(@RequestBody User user) throws SQLException {
			m.addUser(user);
			return true;	
	}

	@Override
	public User Login(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
