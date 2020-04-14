package jar.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection 
{
	// Double Checked Locking based Java implementation of 
	// singleton design pattern 
	private volatile static Connection connection; 
//	private static String connectionUrl = "jdbc:sqlserver://MSI:1433;databaseName=OnlineStore;integratedSecurity=true;";

	//private static String connectionUrl = "jdbc:sqlserver://DESKTOP-MMHA4KL:1433;databaseName=OnlineStore;integratedSecurity=true;";

	private static String connectionUrl = "jdbc:sqlserver://DESKTOP-R2QBSGS:1433;databaseName=OnlineStore;integratedSecurity=true;";

	private DBConnection() {

	}
	
	private static Connection getInstance()
	{
		try {
        	Connection connection = DriverManager.getConnection(connectionUrl);
        	return connection;
        }
        catch (Exception e) {
			// TODO: handle exception
        	return null;
		}
	}

	public static Connection getConnectoin() 
	{ 
		if (connection == null) 
		{ 
			// To make thread safe 
			synchronized (DBConnection.class) 
			{ 
				// check again as multiple threads 
				// can reach above step 
				if (connection==null) 
					connection = getInstance(); 
			} 
		} 
		return connection; 
	}


}
