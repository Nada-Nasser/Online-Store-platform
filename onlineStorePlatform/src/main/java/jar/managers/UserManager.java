package jar.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import jar.DBConnection.DBConnection;
import jar.user.User;

@Service
public class UserManager {
	public List<User> getUsers()
	{
		return null;
	}
	
	public boolean isRegisterd(User user)
	{
		return true;
	}
	
	public boolean addUser(User user) throws SQLException
	{
		Connection conn = DBConnection.getConnectoin();
		if(conn!=null) {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO Buyers(Name, password, email) VALUES (?, ?, ?)");
			stmt.setString(1, user.Name);
			stmt.setString(2, user.Password);
			stmt.setString(3, user.email);
			stmt.executeUpdate();
			return true;
			
		}else {
			return false;
		}
		
		
	}
}
