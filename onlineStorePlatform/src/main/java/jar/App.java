package jar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import jar.SecurityConfigeration.SecurityConfig;
import java.sql.SQLException;


@SpringBootApplication
public class App 
{
   public static void main( String[] args ) throws SQLException
    {	

    	SpringApplication.run(App.class, args);
    }
}
