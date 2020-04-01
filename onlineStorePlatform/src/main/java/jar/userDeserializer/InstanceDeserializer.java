package jar.userDeserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jar.user.*;

public class InstanceDeserializer extends JsonDeserializer<User> 
{
	enum USER 
	{ 
	    BUYER, ADMIN, OWNER; 
	} 
	  

	@Override
	public User deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		 ObjectMapper mapper = (ObjectMapper) jp.getCodec();
	        ObjectNode root = (ObjectNode) mapper.readTree(jp);
	        Class<? extends User> instanceClass = null;
	        
	        if(checkConditionsForUserInstance() == USER.BUYER) {
	            instanceClass = Buyer.class;
	        } 
	        else if(checkConditionsForUserInstance() == USER.OWNER)
	        { 
	            instanceClass = StoreOwner.class;
	        } 
	        else if(checkConditionsForUserInstance() == USER.OWNER)
	        {
	        	instanceClass = StoreOwner.class;
	        }
	        else
	        {
	        	instanceClass = null;
	        }

	        return mapper.convertValue(root, instanceClass);

	}

	private USER checkConditionsForUserInstance() {
	
		return USER.ADMIN;
	}

}
