package socialMediaUserConnections;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	
	static ArrayList<User> users = new ArrayList<User>();
	static Scanner scnr = new Scanner(System.in);
	
	public static void main(String args[]) {
		
		System.out.println("Enter \"Add\", \"Connect\", or \"Display\"");
		
		String input = scnr.nextLine().trim();
		
		if(input.equalsIgnoreCase("Add")){
			addUser.addUserInfo();
		}
		else if(input.equalsIgnoreCase("Connect")){
			addConnection.connectUsers();
		}
		else if(input.equalsIgnoreCase("Display")) {
			System.out.println(Display.display());
		}
		
		main(args);
	}

	static boolean checkUsername(String username) {
		
		for(User user : users) {
			if(username.equalsIgnoreCase(user.username)) {
				return true;
			}
		}
		return false;
	}
}
