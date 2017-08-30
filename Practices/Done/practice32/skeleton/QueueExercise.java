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
    // Fill in the code 
     while(sc.hasNextInt())
       queue.offer(sc.nextInt());
     System.out.println("Items added: " + queue);
   }

   else if (op.equals("Query")) {
    // Fill in the code
     boolean flag = true;
     while(sc.hasNextInt())
     {
      flag =  check(queue, sc.nextInt());
     }
       if(flag)
         System.out.println("Query met: " + queue);
       else
         System.out.println("Query not met: "+ queue);
           
     }
   }
  }
  private static boolean check(QueueLL <Integer> queue, int input)
  {
    while(!queue.isEmpty())
    {
      if(queue.poll() ==  input)
        return true;
    }
    return false;
  }
 // You may write additional method(s) to make your program more modular

}

