import java.util.*;

public class TestPalindromes {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str;

		while (sc.hasNextLine()) {

			str = sc.nextLine();
			System.out.print("\"" + str + "\"");

			// To remove characters that are not letters in the alphabet,
			// represented by the regular expression [^a-zA-Z] in the
			// replaceAll() method below
			str = str.replaceAll("[^a-zA-Z]", "");

			if (isPalindrome(str)) 
				System.out.println(" is a palindrome.");
			else
				System.out.println(" is not a palindrome.");
		}
	}

	// Returns true if str is a palindrome; otherwise, returns false.
	public static boolean isPalindrome(String str) {
		int length = str.length();

		if (length <= 1)
			return true;
		else {
			return ( (Character.toUpperCase(str.charAt(0)) == 
			          Character.toUpperCase(str.charAt(length-1)))
			         && isPalindrome(str.substring(1,length-1)) );
		}
	}
}

