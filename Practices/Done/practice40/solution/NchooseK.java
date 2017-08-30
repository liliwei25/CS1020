// This program reads in a string of N distinct letters in alphabetical order 
// and prints all K-letter strings from it also in alphabetical order.
// Aaron Tan

import java.util.*;

public class NchooseK {

	public static void main(String[] args) {

		// Read input data
		Scanner sc = new Scanner(System.in);
		int numOfLetters = sc.nextInt();
		String str = sc.next();

		generate(numOfLetters, str);
	}

	// Driver (auxiliary) method to call recursive method generate() below
	public static void generate(int k, String str) {
		generate(k, 0, str, "");
	}

	// To generate strings of length k from str
	public static void generate(int k, int next, String str, String ans) {
		if (k == 0) {
			System.out.println(ans);
		}

		for (int i=next; i<str.length(); i++) {
			generate(k-1, i+1, str, ans+str.charAt(i));
		}
	}
}

