package jar.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import jar.DBConnection.DBConnection;
import jar.user.User;

@Service("Admin")
public class AdministratorManager extends UserManager{

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isRegisterd(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUser(User user) {
		Connection conn = DBConnection.getConnectoin();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("INSERT INTO Administrator(Name, password, email) VALUES (?, ?, ?)");
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getEmail());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
