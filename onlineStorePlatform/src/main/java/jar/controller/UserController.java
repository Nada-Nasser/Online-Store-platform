package jar.controller;

import jar.managers.UserManager;
import jar.user.User;

public abstract class UserController {
	
	UserManager controller;
	
	public abstract boolean register(User user);
	public abstract User Login(User user);

}
