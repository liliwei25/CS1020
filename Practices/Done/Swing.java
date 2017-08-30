/**
* Name: Li Liwei
* Matric Number: A0155991R
*/
import java.util.*;

public class Swing {
 private static Stack<Long> trees = new Stack<Long>();
 private static Stack<Long> temp = new Stack<Long>();

    public static void main(String[] args) 
 {
        Scanner scn = new Scanner(System.in);

  int num = scn.nextInt();

  for(int i = 0; i < num; i ++)
  {
   temp.push(scn.nextLong());
  }
  for(int i = 0; i < num; i ++)
  {
   trees.push(temp.pop());
  }

  long tree1 = trees.pop();
  int count = 0;
  long min;

  while(!trees.empty())
  {
   if(trees.peek() >= tree1)
   {
    count+=1;
    tree1 = trees.pop();
   }
   else
   {
     min = 0;
    while(!trees.empty() && trees.peek() < tree1)
    {
      if(trees.peek() > min)
      {
        min = Math.max(min, trees.peek());
        count++;
      }
      temp.push(trees.pop());
    }
    if(!trees.empty())
      count++;
    while(!temp.empty())
    {
      trees.push(temp.pop());
    }
    tree1 = trees.pop();
   }
  }
  System.out.println(count);
    }
}
