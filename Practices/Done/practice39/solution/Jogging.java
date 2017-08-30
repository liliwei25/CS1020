// This program computes the furthest distance (number of road units)
// a jogger can run from PGP and back. Road is divided into units,
// each unit is uphill, flat or downhill with an associated time.
// Aaron Tan

import java.util.*;

public class Jogging {
	public static final int UP = 0;
	public static final int FLAT = 1;
	public static final int DOWN = 2;

	public static void main(String[] args) {

		// Read input data
		Scanner sc = new Scanner(System.in);
		int timeLimit = sc.nextInt();
		int roadUnits = sc.nextInt();
		int[] ufdTimes = new int[3]; // store times for uphill, flat, downhill
		ufdTimes[UP] = sc.nextInt();
		ufdTimes[FLAT] = sc.nextInt();
		ufdTimes[DOWN] = sc.nextInt();

		String roadData = sc.next();

		int answer = solve(timeLimit, roadData, 0, roadUnits, ufdTimes);
		System.out.println(answer);

	}

	// Recursion to compute the number of road units he can run and
	// get back to PGP on time.
	public static int solve(int timeLimit, String roadData, int start, int end, 
	                        int[] ufdTimes) {
		char roadType;
		int timeSpent;

		if (start == end) // completed all units
			return 0;
		else if (timeLimit < 0) // no more time left
			return 0;
		else {
			roadType = roadData.charAt(start);
			if (roadType == 'u' || roadType == 'd')
				timeSpent = ufdTimes[UP] + ufdTimes[DOWN];
			else // roadType == 'f'
				timeSpent = 2 * ufdTimes[FLAT];

			if (timeSpent <= timeLimit) 
				return 1 + solve(timeLimit-timeSpent, roadData, start+1, end, ufdTimes);
			else
				return solve(timeLimit-timeSpent, roadData, start+1, end, ufdTimes);
		}
	}
}

