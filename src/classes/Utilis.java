package classes;

public class Utilis {

	public static boolean checkTelf(String t) {
		String[] result = t.split("");
		String r = "";
        for (int x=0; x<result.length; x++)
           if (!result[x].equals(" ")) {
        	   r += result[x];
           }
        try {
            int d = Integer.parseInt(r);
        } catch (NumberFormatException nfe) {
            return false;
        }
		if(r.length() != 8) {
			return false;
		}
        
		return true;
	}
}
