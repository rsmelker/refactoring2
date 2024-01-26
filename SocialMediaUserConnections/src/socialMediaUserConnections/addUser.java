package socialMediaUserConnections;

public class addUser {

	static void addUserInfo() {
		
		String firstName = getFirstName();
		String lastName = getLastName();
		String username = getUsername();
		String age = getAge();
		
		addUser.createUser(firstName, lastName, username, Integer.parseInt(age));
		System.out.println("User Added");
	}

	private static String getAge() {
		String input;
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
		return age;
	}

	private static String getUsername() {
		String input;
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
		return username;
	}

	private static String getLastName() {
		String input;
		System.out.println("Enter a last name, or enter \"Exit\" to return");
		input = Driver.scnr.nextLine().trim();
		String lastName = null;
		if(!input.equalsIgnoreCase("exit")) {
			lastName = input;
		}
		else{Driver.main(null);};
		return lastName;
	}

	private static String getFirstName() {
		String input;
		System.out.println("Enter a first name, or enter \"Exit\" to return");
		input = Driver.scnr.nextLine().trim();
		String firstName = null;
		if(!input.equalsIgnoreCase("exit")) {
			firstName = input;
		}
		else{Driver.main(null);};
		return firstName;
	}

	static void createUser(String firstName, String lastName, String username, Integer age) {
		Driver.users.add(new User(firstName, lastName, username, age));
	}

}
