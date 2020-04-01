package jar.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Buyer extends User 
{
	public Buyer(String email, String name, String password) {
		super(email, name, password);
	}

	public Buyer() {
		super();
	}
}
