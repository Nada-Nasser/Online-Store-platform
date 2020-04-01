package jar.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import jar.DBConnection.DBConnection;
import jar.user.User;

@Service
public class BuyerManager extends UserManager {

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
		// TODO Auto-generated method stub
			Connection conn = DBConnection.getConnectoin();
			PreparedStatement stmt;
			try {
				stmt = conn.prepareStatement("INSERT INTO Buyers(Name, password, email) VALUES (?, ?, ?)");
				stmt.setString(1, user.Name);
				stmt.setString(2, user.Password);
				stmt.setString(3, user.email);
				stmt.executeUpdate();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	}

}
