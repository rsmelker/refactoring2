package socialMediaUserConnections;

public class Display {

	static String display() {
		
		String display = "";
		
		for(User user : Driver.users) {
			
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
