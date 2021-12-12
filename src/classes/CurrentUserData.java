package classes;

public class CurrentUserData {
	static int roleId;

	public static void change( int id){  
		roleId = id;  
	     }  
	
	public static int getRoleId() {
		return roleId;
	}
	

}
