package jar.controller;

import java.util.List;

import jar.user.User;

public class AdministratorController extends UserController {

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
	
	public List<User> listUsers (User user)
	{
		return null;
		
	}
	
	

}
