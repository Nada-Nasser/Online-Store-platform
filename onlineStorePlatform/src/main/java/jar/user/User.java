package jar.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = Buyer.class)
public abstract class User {
	public  String email;
	public  String Name ;
	public  String Password;
}
