package jar.user;

import javax.persistence.Entity;

@Entity
public abstract class User 
{
	private  String email;
	private  String Name ;
	private  String Password;
	private  boolean logged_in ;
	
	public String getEmail() {
		return email;
	}
	public User(String email, String name, String password) 
	{
		this.email = email;
		Name = name;
		Password = password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public boolean isLogged_in() {
		return logged_in;
	}
	public void setLogged_in(boolean logged_in) {
		this.logged_in = logged_in;
	}
	
	
	
}
