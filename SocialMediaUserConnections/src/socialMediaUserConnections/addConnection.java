package socialMediaUserConnections;

public class addConnection {

	static void connectUsers() {
		
		String input = "";
		
		System.out.println("Enter the username of the user you would like to connect, or enter \"Exit\" to return");
		
		input = Driver.scnr.nextLine().trim();
		String username1 = null;
		if(!input.equalsIgnoreCase("exit")) {
			username1 = input;
		}
		else{Driver.main(null);};
		
		while(!addUser.checkUsername(username1)) {
			System.out.println("Username does not exist. Enter the username of the user you would like to connect, or enter \"Exit\" to return");
			input = Driver.scnr.nextLine().trim();
			username1 = null;
			if(!input.equalsIgnoreCase("exit")) {
				username1 = input;
			}
			else{Driver.main(null);};
		}
		
		System.out.println("Which connection type would you like to use? Enter following or blocking, or enter \"Exit\" to return");
		input = Driver.scnr.nextLine().trim();
		String connectionType = null;
		if(!input.equalsIgnoreCase("exit")) {
			connectionType = input;
		}
		else{Driver.main(null);};
		
		while (!connectionType.equalsIgnoreCase("following") && !connectionType.equalsIgnoreCase("blocking")) {
			System.out.println("Please enter a valid connection type. Enter following or blocking, or enter \"Exit\" to return");
			input = Driver.scnr.nextLine().trim();
			connectionType = null;
			if(!input.equalsIgnoreCase("exit")) {
				connectionType = input;
			}
			else{Driver.main(null);};
		}
		System.out.println("Enter the username of the user you would like to connect to, or enter \"Exit\" to return");
		input = Driver.scnr.nextLine().trim();
		String username2 = null;
		if(!input.equalsIgnoreCase("exit")) {
			username2 = input;
		}
		else{Driver.main(null);};
		
		while(!addUser.checkUsername(username2)) {
			System.out.println("Username does not exist. Enter the username of the user you would like to connect, or enter \"Exit\" to return");
			input = Driver.scnr.nextLine().trim();
			username2 = null;
			if(!input.equalsIgnoreCase("exit")) {
				username2 = input;
			}
			else{Driver.main(null);};
		}
		
		User user1 = null;
		User user2 = null;
		
		for(User user : Driver.users) {
			if(user.username.equalsIgnoreCase(username1)) {
				user1 = user;
			}
			
			if(user.username.equalsIgnoreCase(username2)) {
				user2 = user;
			}
		}
		
		addConnection.createConnection(user1, connectionType, user2);
		System.out.println("Connection Added");
	}

	static void createConnection(User user1, String connectionType, User user2){
		user1.addConnection(connectionType, user2);
	}

}
