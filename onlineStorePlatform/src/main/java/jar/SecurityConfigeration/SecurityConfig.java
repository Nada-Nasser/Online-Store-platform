package jar.SecurityConfigeration;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{

	@Autowired
	DataSource dataSource;
	@Bean
	DataSource dataSource() throws SQLException {
	    SQLServerDataSource dataSource = new SQLServerDataSource();
	    dataSource.setURL("jdbc:sqlserver://DESKTOP-R2QBSGS:1433;databaseName=OnlineStore;integratedSecurity=true;");
	    return dataSource;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/register/*", "/Login/*").permitAll()		
				.antMatchers("/getUsers").hasRole("ADMIN")			
				.and()
			.formLogin();
		
		http.csrf().disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
			.inMemoryAuthentication()
				.withUser("admin").password("123").roles("ADMIN");
		/*auth
			.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery(" ") // query to get the user name , password, email,... of the users 
			.authoritiesByUsernameQuery(" "); // query to get the "role" of the users returned from the prev. query
	*/
	}
	
}
