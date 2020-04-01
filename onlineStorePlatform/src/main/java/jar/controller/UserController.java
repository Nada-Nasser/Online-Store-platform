package jar.controller;

import java.sql.SQLException;

import jar.managers.UserManager;
import jar.user.User;

public abstract class UserController 
{
	public abstract boolean register(User user)  throws SQLException;
	
	public abstract User Login(User user) throws SQLException;
}
