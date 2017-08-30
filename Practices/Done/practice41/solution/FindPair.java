// This program reads in a target sum and a list of integers 
// sorted in ascending order, and finds two distinct integers 
// in the list that add up to that sum.

import java.util.*;

public class FindPair {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter sum: ");
		int targetSum = sc.nextInt();

		System.out.print("Enter number of elements: ");
		int size = sc.nextInt();
		int[] sortedArray = new int[size];

		System.out.print("Enter " + size + " integers: ");
		for (int i=0; i<size; i++) {
			sortedArray[i] = sc.nextInt();
		}

		Pair<Integer> answer = findPair(sortedArray, targetSum);
		if (answer == null) {
			System.out.println("No solution!");
		}
		else {
			System.out.print("Values at index " + answer.getFirst());
			System.out.print(" (" + sortedArray[answer.getFirst()]);
			System.out.print(") and index " + answer.getSecond());
			System.out.println(" (" + sortedArray[answer.getSecond()] + ")");
		}
	}

	// Find two distinct elements in arr that add up to targetSum.
	// Precond: arr[i] < arr[i+1], for i=0 .. arr.length-2
	public static Pair<Integer> findPair(int[] arr, int targetSum) {
		int left = 0, right = arr.length-1;
		int trySum;

		// We use two indices, one from leftmost position, one from rightmost
		// position of the array. If the sum < target, which means the
		// sum is too small, left will move 1 position to the right so that
		// the sum will increase in next iteration. Likewise, if sum > target 
		// right will move 1 position to the left so that the sum will decrease
		// in the next iteration.
		while (left < right) {
			trySum = (arr[left] + arr[right]);

			if (trySum < targetSum)
				left++;
			else  if (trySum > targetSum)
				right--;
			else { // found!
				return new Pair<Integer>(left, right);
			}
		}
		return null;
	}
}

