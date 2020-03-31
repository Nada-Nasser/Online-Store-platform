package jar.controller;

import java.sql.SQLException;

import jar.managers.UserManager;
import jar.user.User;

public abstract class UserController {
	
	UserManager manager = new UserManager();
	
	public abstract User register(User user);
	public abstract User Login(User user) throws SQLException;

}
