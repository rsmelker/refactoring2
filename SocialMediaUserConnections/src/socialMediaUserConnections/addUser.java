package socialMediaUserConnections;

public class addUser {

	static void addPrompt() {
		
		boolean taken = true;
		String input = "";
		
		System.out.println("Enter a first name, or enter \"Exit\" to return");
		input = Driver.scnr.nextLine().trim();
		String firstName = null;
		if(!input.equalsIgnoreCase("exit")) {
			firstName = input;
		}
		else{Driver.main(null);};
		System.out.println("Enter a last name, or enter \"Exit\" to return");
		input = Driver.scnr.nextLine().trim();
		String lastName = null;
		if(!input.equalsIgnoreCase("exit")) {
			lastName = input;
		}
		else{Driver.main(null);};
		System.out.println("Enter a username, or enter \"Exit\" to return");
		input = Driver.scnr.nextLine().trim();
		String username = null;
		if(!input.equalsIgnoreCase("exit")) {
			username = input;
		}
		else{Driver.main(null);};
		
		while(Driver.checkUsername(username)) {
			System.out.println("Username not available. Enter a username, or enter \"Exit\" to return");
			input = Driver.scnr.nextLine().trim();
			username = null;
			if(!input.equalsIgnoreCase("exit")) {
				username = input;
			}
			else{Driver.main(null);};
		}
		
		System.out.println("Enter an age, or enter \"Exit\" to return");
		input = Driver.scnr.nextLine().trim();
		String age = null;
		if(!input.equalsIgnoreCase("exit")) {
			age = input;
		}
		else{Driver.main(null);};
		while(!age.matches("\\d+")) {
			System.out.println("Please enter a valid age, using only digits, or enter \"Exit\" to return");
			input = Driver.scnr.nextLine().trim();
			age = null;
			if(!input.equalsIgnoreCase("exit")) {
				age = input;
			}
			else{Driver.main(null);};
		}
		
		Driver.addUser(firstName, lastName, username, Integer.parseInt(age));
		System.out.println("User Added");
	}

}
