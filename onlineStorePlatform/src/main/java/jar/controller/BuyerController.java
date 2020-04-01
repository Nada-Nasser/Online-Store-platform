package jar.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jar.managers.UserManager;
import jar.user.User;

@RestController
public class BuyerController extends UserController {

	@Autowired
	UserManager m = new UserManager();
	
	@Override
	@RequestMapping(method=RequestMethod.POST , value = "/registerBuyer")
	public boolean register(@RequestBody User user) {
		// TODO Auto-generated method stub
		if(m.isRegisterd(user)) {
			try {
				return(m.addUser(user));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			return false;
		}
			return false;
	}

	@Override
	public User Login(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
