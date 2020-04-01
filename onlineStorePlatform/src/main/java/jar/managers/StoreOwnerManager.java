package jar.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.stereotype.Service;

import jar.DBConnection.DBConnection;
import jar.user.User;

@Service("Owner")
public class StoreOwnerManager extends UserManager {

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isRegisterd(User user) throws SQLException 
	{
		Connection connection = DBConnection.getConnectoin();
		String email = user.getEmail();
		String Password = user.getPassword();
		String Name = user.getName();
		
		String showSql = "SELECT Name, password, email \r\n" + 
				"FROM StoreOwner WHERE email = '" + email + "'  AND\r\n" + 
				"password = '" + Password + "' AND Name = '" + Name + "';";
		
		ResultSet resultSet = null;

		try (
			PreparedStatement prepsInsertProduct = 
			connection.prepareStatement(showSql, Statement.RETURN_GENERATED_KEYS);) 
		{
			prepsInsertProduct.execute();
			resultSet = prepsInsertProduct.getResultSet();
			 
			if(resultSet.next()){
		         return true;        
		     }
			else
				return false;
		}
	}

	@Override
	public boolean addUser(User user) {
		Connection conn = DBConnection.getConnectoin();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("INSERT INTO StoreOwner(Name, password, email) VALUES (?, ?, ?)");
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
