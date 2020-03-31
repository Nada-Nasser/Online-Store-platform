package jar.controller;

import jar.managers.UserManager;
import jar.user.User;

public abstract class UserController {
	
	UserManager manager;
	
	public abstract User register(User user);
	public abstract User Login(User user);

}
