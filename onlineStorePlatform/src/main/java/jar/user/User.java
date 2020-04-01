package jar.user;


import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

//@JsonDeserialize(as = Buyer.class)

@JsonTypeInfo(use = Id.NAME,
include = JsonTypeInfo.As.PROPERTY,
property = "type")
@JsonSubTypes({
@Type(value = Buyer.class, name = "Buyer"),
@Type(value = Administrator.class, name = "Admin"),
@Type(value = StoreOwner.class, name = "Owner"),
})
public abstract class User 
{
	private  String email;
	private  String Name ;
	private  String Password;
	
	public String getEmail() {
		return email;
	}
	public User(String email, String name, String password) 
	{
		this.email = email;
		Name = name;
		Password = password;
	}
	
	public User()
	{
		
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
}
