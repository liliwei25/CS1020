import java.util.*;

public class Chemistry 
{
 public static void main(String[] args) 
 {
   Scanner scn = new Scanner(System.in);
   int num = scn.nextInt();
   HashMap<Character, Integer> elements = new HashMap<Character, Integer>();
   
   for(int i = 0; i < num; i ++)
     elements.put(scn.next().charAt(0), scn.nextInt());
   scn.nextLine();
   String input = scn.nextLine();
   Stack<Integer> formula = new Stack<Integer>();
   for(int i = 0; i < input.length(); i++)
   {
     if(Character.isDigit(input.charAt(i)))
     {
       formula.push(formula.pop() * Character.getNumericValue(input.charAt(i)));
     }
     else if(input.charAt(i) == '(')
       formula.push(-1);
     else if(input.charAt(i) == ')')
     {
       int sum = 0;
       while(formula.peek() != -1)
       {
         sum += formula.pop();
       }
       formula.pop();
       formula.push(sum);
     }
     else
       formula.push(elements.get(input.charAt(i)));
   }
   int sum = 0;
   while(!formula.empty())
   {
     sum+= formula.pop();
   }
   System.out.println(sum);
 }
}
