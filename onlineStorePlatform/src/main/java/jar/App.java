package jar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;

@SpringBootApplication
public class App 
{
	//public static final String  connectionUrl ="jdbc:sqlserver://DESKTOP-R2QBSGS:1433;databaseName=OnlineStore;integratedSecurity=true;";

    public static void main( String[] args )
    {
    	String connectionUrl = "jdbc:sqlserver://DESKTOP-R2QBSGS:1433;databaseName=OnlineStore;integratedSecurity=true;";

        try {
            // Load SQL Server JDBC driver and establish connection.
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                System.out.println("Done.");
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
		
    	//SpringApplication.run(App.class, args);
    }
}
