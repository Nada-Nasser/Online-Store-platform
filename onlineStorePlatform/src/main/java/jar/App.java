package jar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jar.DBConnection.DBConnection;
import jar.controller.BuyerController;
import jar.user.Buyer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;

@SpringBootApplication
public class App 
{
   public static void main( String[] args ) throws SQLException
    {	

    	SpringApplication.run(App.class, args);
    }
}
