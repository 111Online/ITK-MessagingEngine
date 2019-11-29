package OctopusConsortium.Core;

public class PostcodeHelper {
	public static String AddSpaceToPostcode(String postCode) {
		
		postCode = postCode.trim();
		
		//postcode is longer than 3 characters and does not already contain a space
		if (postCode.length() > 3 && postCode.indexOf(' ') == -1) {
			int secondEnd = postCode.length();
			int secondStart =  postCode.length() - 3;
			
			String secondHalf = postCode.substring(secondStart, secondEnd);
			String firstHalf = postCode.substring(0, secondStart);
			
			return firstHalf + " " + secondHalf;
		}
		
		return postCode;
	}
}
