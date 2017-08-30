// This program processes a list of "add" and "query" operations
// on a stack:
//    Add <a list of integers>: to push integers into stack
//    Query <a list of integers>: to check if integers are present
//                                in stack by popping elements
import java.util.*;

public class StackExercise {
	public static void main(String [] args) throws NoSuchElementException {

		StackLL <Integer> stack = new StackLL <Integer> ();
		Scanner sc = new Scanner(System.in);
		String op;

		while (sc.hasNext()) {
			op = sc.next();

			if (op.equals("Add")) {
				while (sc.hasNextInt()) {
					stack.push(sc.nextInt());
				}
				System.out.println("Items added: " + stack);
			}

			else if (op.equals("Query")) {
				boolean success = true;
				while (sc.hasNextInt()) {
					if (!found(stack, sc.nextInt())) {
						success = false;
						break;
					}
				}
				if (success) 
					System.out.print("Query met: ");
				else
					System.out.print("Query not met: ");
				System.out.println(stack);
			}
		}
	}

	// To find an item in the stack by repeatedly popping item
	// to see if it is the item required
	public static boolean found(StackLL <Integer> stack, int i) {
		while (!stack.isEmpty()) {
			if (stack.pop() == i) 
				return true;
		}
		return false;
	}

}

