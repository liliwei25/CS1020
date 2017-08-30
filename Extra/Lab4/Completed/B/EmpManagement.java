import java.util.*;

/* Service class representing an employee */

/* Client class to simulate the employee management system */
public class EmpManagement 
{
    public static void main(String[] args) 
    {
      Scanner sc = new Scanner(System.in);
      Stack<Employee> hired = new Stack<Employee>();
      Stack<Employee> tempList = new Stack<Employee>();
      
      int num = sc.nextInt();
      for(int i = 0; i < num; i++)
      {
        String input = sc.next();
        if(input.equals("hire"))
        {
          Employee temp = new Employee(sc.next(), sc.nextInt());
          System.out.println(input + " " + temp.getName() + " " + temp.getRank());
          if(hired.empty())
            hired.push(temp);
          else
          {
            if(hired.peek().getRank() >= temp.getRank())
              hired.push(temp);
            else
            {
              while(!hired.empty() && hired.peek().getRank() < temp.getRank())
              {
                tempList.push(hired.pop());
              }
              hired.push(temp);
              while(!tempList.empty())
              {
                hired.push(tempList.pop());
              }
            }
          }
        }
        else if(input.equals("fire"))
        {
          int count = sc.nextInt();
          System.out.println(input + " " + count);
          for(int n = 0; n < count; n++)
            hired.pop();
        }
        else if(input.equals("promote"))
        {
          Employee temp = new Employee(sc.next(), sc.nextInt());
          System.out.println(input + " " + temp.getName() + " " + temp.getRank());
          while(!hired.empty())
          {
            if(temp.getName().equals(hired.peek().getName()))
            {
              hired.pop();
              break;
            }
            else
            {
              tempList.push(hired.pop());
            }
          }
          while(!tempList.empty())
          {
            hired.push(tempList.pop());
          }
          if(hired.empty())
            hired.push(temp);
          else
          {
            if(hired.peek().getRank() >= temp.getRank())
              hired.push(temp);
            else
            {
              while(!hired.empty() && hired.peek().getRank() < temp.getRank())
              {
                tempList.push(hired.pop());
              }
              hired.push(temp);
              while(!tempList.empty())
              {
                hired.push(tempList.pop());
              }
            }
          }
        }
        if(hired.empty()) System.out.println("@");
        while(!hired.empty())
        {
          Employee temp = hired.pop();
          System.out.println(temp.getName() + " " + temp.getRank());
          tempList.push(temp);            
        }
        System.out.println();
        while(!tempList.empty())
          hired.push(tempList.pop());
      }
    }
}
class Employee 
{
  private String _name;
  private int _rank;
  
  public Employee(String name, int rank)
  {
    _name = name;
    _rank = rank;
  }
  public String getName(){return _name;}
  public int getRank(){return _rank;}
}
