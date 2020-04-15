package jar.SecurityConfigeration;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{

/*
   @Bean
	DataSource dataSource() throws SQLException {
    SQLServerDataSource dataSource = new SQLServerDataSource();
    dataSource.setUser("sa");
    dataSource.setPassword("");
    dataSource.setURL("jdbc:sqlserver://DESKTOP-R2QBSGS:1433;databaseName=OnlineStore");
    return dataSource;
	}
	 
*/	 

	@Autowired 
	DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/register/*", "/Login/*").permitAll().anyRequest().authenticated()	
				.antMatchers("/getUsers").hasRole("Admin").anyRequest().authenticated()
				.and()
			.formLogin();
		
		http.csrf().disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {		
		auth
			.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("SELECT email,password,enabled FROM Administrator WHERE email = ?") // query to get the user name , password, email,... of the users 
			.authoritiesByUsernameQuery("SELECT email,authority FROM Administrator WHERE email = ?"); // query to get the "role" of the users returned from the prev. query
	}
	
}
