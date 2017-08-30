import java.util.*;

class Soldier {
 public static void main(String[] args) 
 {
   Scanner scn = new Scanner(System.in);
   
   int num = scn.nextInt();
   
   Stack<Integer> tunnel = new Stack<Integer>();
   Stack<Integer> start = new Stack<Integer>();
   Queue<Integer> end = new LinkedList<Integer>();
   
   for(int i = num; i >= 1; i--)
   {
     start.push(i);
   }
   while(scn.hasNextInt())
   {
     while(end.peek()!=null)
       end.poll();
     for(int i = 0; i < num; i++)
     {
       end.offer(scn.nextInt());
     }
     while(end.peek()!= null)
     {
       if(!start.empty() && end.peek() == start.peek())
       {
         start.pop();
         end.poll();
       }
       else if(!tunnel.empty() && end.peek() == tunnel.peek())
       {
         tunnel.pop();
         end.poll();
       }
       else
       {
         if(start.empty()) break;
         tunnel.push(start.pop());
       }
       //if(!end.empty() && !start.empty() && !tunnel.empty() && end.peek()!= start.peek() && end.peek()!= tunnel.peek())
         //break;
     }
     if(end.peek()==null) System.out.println("YES");
     else System.out.println("NO");
     for(int i = num; i >= 1; i--)
     {
       start.push(i);
     }
     while(!tunnel.empty())
       tunnel.pop();
   }
 }
}