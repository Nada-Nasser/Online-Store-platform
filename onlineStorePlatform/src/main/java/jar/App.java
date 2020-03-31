package jar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import DBConnection.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;

@SpringBootApplication
public class App 
{
   public static void main( String[] args )
    {
    	
    	Connection c =  DBConnection.getInstance();
    	
    //	SpringApplication.run(App.class, args);
    }
}
