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
			addPrompt();
		}
		else if(input.equalsIgnoreCase("Connect")){
			connectPrompt();
		}
		else if(input.equalsIgnoreCase("Display")) {
			System.out.println(display());
		}
		
		main(args);
	}
	
	static void addPrompt() {
		
		boolean taken = true;
		String input = "";
		
		System.out.println("Enter a first name, or enter \"Exit\" to return");
		input = scnr.nextLine().trim();
		String firstName = null;
		if(!input.equalsIgnoreCase("exit")) {
			firstName = input;
		}
		else{main(null);};
		System.out.println("Enter a last name, or enter \"Exit\" to return");
		input = scnr.nextLine().trim();
		String lastName = null;
		if(!input.equalsIgnoreCase("exit")) {
			lastName = input;
		}
		else{main(null);};
		System.out.println("Enter a username, or enter \"Exit\" to return");
		input = scnr.nextLine().trim();
		String username = null;
		if(!input.equalsIgnoreCase("exit")) {
			username = input;
		}
		else{main(null);};
		
		while(checkUsername(username)) {
			System.out.println("Username not available. Enter a username, or enter \"Exit\" to return");
			input = scnr.nextLine().trim();
			username = null;
			if(!input.equalsIgnoreCase("exit")) {
				username = input;
			}
			else{main(null);};
		}
		
		System.out.println("Enter an age, or enter \"Exit\" to return");
		input = scnr.nextLine().trim();
		String age = null;
		if(!input.equalsIgnoreCase("exit")) {
			age = input;
		}
		else{main(null);};
		while(!age.matches("\\d+")) {
			System.out.println("Please enter a valid age, using only digits, or enter \"Exit\" to return");
			input = scnr.nextLine().trim();
			age = null;
			if(!input.equalsIgnoreCase("exit")) {
				age = input;
			}
			else{main(null);};
		}
		
		addUser(firstName, lastName, username, Integer.parseInt(age));
		System.out.println("User Added");
	}
	
	static boolean checkUsername(String username) {
		
		for(User user : users) {
			if(username.equalsIgnoreCase(user.username)) {
				return true;
			}
		}
		return false;
	}
	
	static void connectPrompt() {
		
		String input = "";
		
		System.out.println("Enter the username of the user you would like to connect, or enter \"Exit\" to return");
		
		input = scnr.nextLine().trim();
		String username1 = null;
		if(!input.equalsIgnoreCase("exit")) {
			username1 = input;
		}
		else{main(null);};
		
		while(!checkUsername(username1)) {
			System.out.println("Username does not exist. Enter the username of the user you would like to connect, or enter \"Exit\" to return");
			input = scnr.nextLine().trim();
			username1 = null;
			if(!input.equalsIgnoreCase("exit")) {
				username1 = input;
			}
			else{main(null);};
		}
		
		System.out.println("Which connection type would you like to use? Enter following or blocking, or enter \"Exit\" to return");
		input = scnr.nextLine().trim();
		String connectionType = null;
		if(!input.equalsIgnoreCase("exit")) {
			connectionType = input;
		}
		else{main(null);};
		
		while (!connectionType.equalsIgnoreCase("following") && !connectionType.equalsIgnoreCase("blocking")) {
			System.out.println("Please enter a valid connection type. Enter following or blocking, or enter \"Exit\" to return");
			input = scnr.nextLine().trim();
			connectionType = null;
			if(!input.equalsIgnoreCase("exit")) {
				connectionType = input;
			}
			else{main(null);};
		}
		System.out.println("Enter the username of the user you would like to connect to, or enter \"Exit\" to return");
		input = scnr.nextLine().trim();
		String username2 = null;
		if(!input.equalsIgnoreCase("exit")) {
			username2 = input;
		}
		else{main(null);};
		
		while(!checkUsername(username2)) {
			System.out.println("Username does not exist. Enter the username of the user you would like to connect, or enter \"Exit\" to return");
			input = scnr.nextLine().trim();
			username2 = null;
			if(!input.equalsIgnoreCase("exit")) {
				username2 = input;
			}
			else{main(null);};
		}
		
		User user1 = null;
		User user2 = null;
		
		for(User user : users) {
			if(user.username.equalsIgnoreCase(username1)) {
				user1 = user;
			}
			
			if(user.username.equalsIgnoreCase(username2)) {
				user2 = user;
			}
		}
		
		addConnection(user1, connectionType, user2);
		System.out.println("Connection Added");
	}
	
	static void addUser(String firstName, String lastName, String username, Integer age) {
		users.add(new User(firstName, lastName, username, age));
	}
	
	static void addConnection(User user1, String connectionType, User user2){
		user1.addConnection(connectionType, user2);
	}
	
	static String display() {
		
		String display = "";
		
		for(User user : users) {
			
			String following = "";
			String blocked = "";
			
			if(user.connectedTo.get("following") != null){
				
				for(int i = 0; i < user.connectedTo.get("following").size(); i++) {
					
					following = following + user.connectedTo.get("following").get(i).username + ", ";
				}
			}
			else { following = "Nobody"; }
			
			if(user.connectedTo.get("blocking") != null) {
				for(int i = 0; i < user.connectedTo.get("blocking").size(); i++) {
					
					blocked = blocked + user.connectedTo.get("blocking").get(i).username + ", ";
				}
			} 
			else { blocked = "Nobody"; }

			following = following.strip().replaceAll(",$", "");
			blocked = blocked.strip().replaceAll(",$", "");
			
			display = display + "Name: " + user.firstName + " " + user.lastName + ", Username: " + user.username + ", Age: " + user.age + 
					". " + "Following: " + following + ". Blocked: " + blocked + ". \n";
		}
		return display;
	}
}
