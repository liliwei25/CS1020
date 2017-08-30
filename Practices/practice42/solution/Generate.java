// Generate data for Maximum Subsequence Sum problem
import java.util.*;

public class Generate {
	static final int LIMIT = 1000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		int n = sc.nextInt();
		System.out.println(n);
		for (int i=0; i<n; i++) {
			System.out.println(rand.nextInt(LIMIT) - LIMIT/2);
		}
	}
}

