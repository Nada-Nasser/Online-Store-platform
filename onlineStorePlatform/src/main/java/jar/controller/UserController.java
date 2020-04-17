package jar.controller;

import java.sql.SQLException;
import jar.user.User;

public interface UserController 
{
	public boolean register(User user)  throws SQLException;
	
	public User Login(User user) throws SQLException;
}
