import java.util.*;

public class Orders 
{
  private LinkedList<Stack<Integer>> system = new LinkedList<Stack<Integer>>();
  private int processors;
  private int orders;
  
  public void run() 
  {
    // implement your "main" method here
    Scanner scn = new Scanner(System.in);
    
    processors = scn.nextInt();
    orders = scn.nextInt();
    
    for(int i = 0; i < processors; i++)
      system.add(new Stack<Integer>());
    for(int i = 0; i < orders; i++)
    {
      sortOrders(scn.nextInt(), scn.nextInt());
    }
    printSystem();
  }
  private void printSystem()
  {
    Stack<Integer> temp = new Stack<Integer>();
    Stack<Integer> indexes = new Stack<Integer>();
    
    int max = 0;
    int index = 0, count = 1;
    for(int i = 0; i < orders; i++)
    {
      max = 0;
      for(int n = 0; n < processors; n++)
      {
        if(!system.get(n).empty() && system.get(n).peek() > max)
        {
          max = system.get(n).peek();
          index = n;
        }
      }
      temp.push(system.get(index).pop());
      indexes.push(index);
      //System.out.println(count++ + " " +index + " " + system.get(index).pop());
    }
    for(int i = 0; i < orders; i++)
    {
      System.out.println(count++ + " " +(indexes.pop()+1) + " " + temp.pop());
    }
  }
  private void sortOrders(int startTime, int timeNeeded)
  {   
    int min = 0;
    int index =0 ;
    for(int i = 0; i < processors; i ++)
    {
      if(system.get(i).empty())
      {
        system.get(i).push(startTime + timeNeeded);
        return;
      }
      if(!system.get(i).empty() && system.get(i).peek() < min)
      {
        min = system.get(i).peek();
        index = i;
      }
    }
    if(system.get(index).peek() > (startTime))
      system.get(index).push(system.get(index).peek() + timeNeeded);
    else
      system.get(index).push(startTime + timeNeeded);
  }
  public static void main(String[] args) 
  {
    Orders o = new Orders();
    o.run();
  }
}