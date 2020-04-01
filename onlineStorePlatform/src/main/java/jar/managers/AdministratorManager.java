package jar.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jar.DBConnection.DBConnection;
import jar.user.*;

@Service("Admin")
public class AdministratorManager extends UserManager{

	public List<User> getUsers() throws SQLException
	{
		
		List <User> users = new ArrayList<User>();
		Connection conn = DBConnection.getConnectoin();
		String Buyerquery = "SELECT * FROM Buyers";
		String Ownerquery = "SELECT * FROM StoreOwner";
		PreparedStatement BuyerpreparedStatement = conn.prepareStatement(Buyerquery);
		PreparedStatement OwnerpreparedStatement = conn.prepareStatement(Ownerquery);
        ResultSet BuyerresultSet = BuyerpreparedStatement.executeQuery();
        ResultSet OwnerresultSet = OwnerpreparedStatement.executeQuery();
        
            while (BuyerresultSet.next()) 
            {
                String email = BuyerresultSet.getString("email");
                String name = BuyerresultSet.getString("Name");
                String password = BuyerresultSet.getString("password");
                
                User obj = new Buyer(email , name , password);
                users.add(obj);
            }
            
            while (OwnerresultSet.next()) 
            {
                String email = OwnerresultSet.getString("email");
                String name = OwnerresultSet.getString("Name");
                String password = OwnerresultSet.getString("password");
                
                User obj = new StoreOwner(email , name , password);
                users.add(obj);
            }
            
            return users;
	}

	@Override
	public boolean isRegisterd(User user) throws SQLException {
		Connection connection = DBConnection.getConnectoin();
		String email = user.getEmail();
		String Password = user.getPassword();
		String Name = user.getName();
		
		String showSql = "SELECT Name, password, email \r\n" + 
				"FROM Administrator  WHERE email = '" + email + "'  AND\r\n" + 
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

}
