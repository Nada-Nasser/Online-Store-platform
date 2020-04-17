package jar.SecurityConfigeration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{
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
