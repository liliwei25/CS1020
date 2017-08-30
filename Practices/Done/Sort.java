import java.util.*;

public class Sort
{
  private Stack<Integer> list;
  private Queue<Integer> printList;
  private void run()
  {
    Scanner scn = new Scanner(System.in);
    Stack<Integer> tempList= new Stack<Integer>();
    while(scn.hasNextInt())
    {
      int input = scn.nextInt();
      if(list.empty())
        list.push(input);
      else
      {
        if(input < list.peek())
          list.push(input);
        else
        {
          while(!list.empty())//&& input >= list.peek()
          {
            if(list.peek() <= input)
            {
              list.pop();
              tempList.push(input);
            }
            else
            {
              tempList.push(list.pop());
            }
          }
          list.push(input);
          while(!tempList.empty())
            printList.offer(tempList.pop());
        }
      }
    }
    //while(!list.empty())
    //  tempList.push(list.pop());
   // while(!tempList.empty())
   // {
      //System.out.print(tempList.pop() + " ");
    //  list.push(tempList.pop());
   // }
    while(printList.peek()!= null)
    {
      System.out.print(printList.poll() + " ");
    }
    System.out.println();
  }
  private Sort()
  {
    list = new Stack<Integer>();
    printList = new LinkedList<Integer>();
  }
  public static void main(String args[])
  {
    Sort newThis = new Sort();
    newThis.run();
  }
}
/*
int max = list.pop();
    tempList.push(max);
    int temp;
    while(!list.empty())
    {
      if(max > list.peek())
      {
        temp = list.pop();
        tempList.push(max);
        if(!list.empty() && temp > list.peek())
          max = temp;
      }
      else
      {
        max = list.peek();
        tempList.push(list.pop());
      }
    }
    */