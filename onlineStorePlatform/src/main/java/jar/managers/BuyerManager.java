package jar.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

import jar.DBConnection.DBConnection;
import jar.user.User;

@Service("Buyer")
public class BuyerManager implements UserManager {

	

	@Override
	public boolean isRegisterd(User user) throws SQLException
	{		
		Connection connection = DBConnection.getConnectoin();
		String email = user.getEmail();
		String Password = user.getPassword();
		String Name = user.getName();
		
		String showSql = "SELECT Name, password, email \r\n" + 
				"FROM Buyers WHERE email = '" + email + "'  AND\r\n" + 
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
	public boolean addUser(User user) throws SQLException {
			if(isRegisterd(user))
			{
				return false;
			}else
			{
				Connection conn = DBConnection.getConnectoin();
				PreparedStatement stmt;
				try {
					stmt = conn.prepareStatement("INSERT INTO Buyers(Name, password, email,authority,enabled) VALUES (?, ?, ? , ? , ?)");
					stmt.setString(1, user.getName());
					stmt.setString(2, user.getPassword());
					stmt.setString(3, user.getEmail());
					stmt.setString(4,"Buyer");
					stmt.setBoolean(5, true);
					stmt.executeUpdate();
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
			
	}

}
