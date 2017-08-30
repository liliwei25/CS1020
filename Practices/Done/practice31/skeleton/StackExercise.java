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
    // Fill in the code 
     while(sc.hasNextInt())
     {
       stack.push(sc.nextInt());
     }
     System.out.println("Items added: " + stack);
   }

   else if (op.equals("Query")) {
    // Fill in the code 
     LinkedList<Integer> list = new LinkedList<Integer>();
     while(sc.hasNextInt())
       list.add(sc.nextInt());
     while(list.size()!=0)
     {
       if(stack.isEmpty()) break;
       if(list.get(0) == (stack.peek()))
       {
         list.remove(stack.pop());
       }
       else
         stack.pop();
     }
     if(!stack.isEmpty())
       System.out.println("Query met: " + stack);
     else if(list.size() == 0)
       System.out.println("Query met: " + stack);
     else
       System.out.println("Query not met: " + stack);

   }
  }
 }

 // You may write additional method(s) to make your program more modular

}

