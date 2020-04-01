package jar.controller;

import java.util.List;

import jar.user.User;

public class StoreOwnerController extends UserController {

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User Login(User user) {
		return user;
		// TODO Auto-generated method stub
	}
	
	public List<User> ListUsers ()
	{
		
		return null;
	}
	
}
