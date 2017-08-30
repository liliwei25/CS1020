// This program processes a list of "add" and "query" operations
// on a queue:
//    Add <a list of integers>: to enqueue integers into queue
//    Query <a list of integers>: to check if integers are present
//                                in queue by dequeueing elements
import java.util.*;

public class QueueExercise {
	public static void main(String [] args) throws NoSuchElementException {

		QueueLL <Integer> queue = new QueueLL <Integer> ();
		Scanner sc = new Scanner(System.in);
		String op;

		while (sc.hasNext()) {
			op = sc.next();

			if (op.equals("Add")) {
				while (sc.hasNextInt()) {
					queue.offer(sc.nextInt());
				}
				System.out.println("Items added: " + queue);
			}

			else if (op.equals("Query")) {
				boolean success = true;
				while (sc.hasNextInt()) {
					if (!found(queue, sc.nextInt())) {
						success = false;
						break;
					}
				}
				if (success) 
					System.out.print("Query met: ");
				else
					System.out.print("Query not met: ");
				System.out.println(queue);
			}
		}
	}

	// To find an item in the queue by repeatedly dequeueing item
	// in front to see if it is the item required
	public static boolean found(QueueLL <Integer> queue, int i) {
		while (!queue.isEmpty()) {
			if (queue.poll() == i) 
				return true;
		}
		return false;
	}

}

