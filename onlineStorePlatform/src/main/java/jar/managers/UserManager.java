package jar.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import jar.DBConnection.DBConnection;
import jar.user.User;

@Service
public abstract class UserManager {
	public abstract List<User> getUsers();
	public abstract boolean isRegisterd(User user);
	public abstract boolean addUser(User user) throws SQLException;
	
}
