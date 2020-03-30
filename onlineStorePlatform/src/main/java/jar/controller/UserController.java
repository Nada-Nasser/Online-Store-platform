package jar.controller;

import jar.user.User;

public abstract class UserController {
	
	UserController controller;
	
	public abstract User register(User user);
	public abstract User Login(User user);

}
