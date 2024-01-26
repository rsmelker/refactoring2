package socialMediaUserConnections;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
	
	String firstName;
	String lastName;
	String username;
	Integer age;
	ArrayList<User> following = new ArrayList<User>();
	ArrayList<User> blocked = new ArrayList<User>();
	HashMap<String, ArrayList<User>> connectedTo = new HashMap<String, ArrayList<User>>();
	
	User(String firstName, String lastName, String username, Integer age){
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.age = age;
	}
	
	void addConnection(String connectionType, User user) {
		
		if(connectionType.equalsIgnoreCase("blocking")) {
			
			if(!blocked.contains(user)) {
				blocked.add(user);
			}
			connectedTo.put(connectionType, blocked);
		}
		
		if(connectionType.equalsIgnoreCase("following")) {
			
			if(!following.contains(user)) {
				following.add(user);
			}
			connectedTo.put(connectionType, following);
		}
	}
	
	
	

}
