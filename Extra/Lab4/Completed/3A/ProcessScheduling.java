import java.util.*;


/* Class representing process scheduling service */
public class ProcessScheduling 
{
    private Stack<Process> processList;
    private Stack<Process> tempList;
    private int maxProcesses;
    
    public void run()
    {
      processList = new Stack<Process>();
      tempList = new Stack<Process>();
      
      maxProcesses = 5;
      int numProcesses = 0;
      
      Scanner scn = new Scanner(System.in);
      int num = scn.nextInt();
      
      String input = "";
      for(int n = 0; n < num; n ++)
      {
        input = scn.next();
        if(input.equals("execute"))
        {
          if(processList.empty())
          {
            processList.push(new Process(scn.next(), scn.nextInt()));
            //numProcesses++;
          }
          else
          {
            Process temp = new Process(scn.next(), scn.nextInt());
            if(numProcesses == maxProcesses) 
            {
              if(temp.getPriority() > processList.peek().getPriority())
              {
                processList.pop();
                numProcesses--;
              }
              else
              {
                if(processList.empty()) System.out.println("---\n");
                else
                  printProcessList();
                continue;
              }
            }
            while(!processList.empty() && processList.peek().getPriority() <= temp.getPriority())
            {
              tempList.push(processList.pop());
            }
            processList.push(temp);
            while(!tempList.empty())
              processList.push(tempList.pop());
          }
          numProcesses++;
        }
        else if(input.equals("kill"))
        {
          int count = scn.nextInt();
          for(int i = 0; i < count; i++)
          {
            if(processList.empty()) break;
            processList.pop();
            numProcesses--;
          }
        }
        if(processList.empty()) System.out.println("---\n");
        else
          printProcessList();
      }
    }
    private void printProcessList()
    {
      while(!processList.empty())
      {
        Process temp = processList.pop();
        System.out.println(temp);
        tempList.push(temp);
      }
      System.out.println();
      while(!tempList.empty())
      {
        processList.push(tempList.pop());
      }
    }
    public static void main(String[] args)
    {
      ProcessScheduling newThis = new ProcessScheduling();
      newThis.run();
    }
} 
/* Class representing a process */
class Process {    
    private String processName;
    private int priority;

    public Process(String processName, int priority) {
        this.processName = processName;
        this.priority = priority;
    }
    public String getProcessName() {return processName;}
    public void setProcessName(String processName) {this.processName = processName;}
    public int getPriority() {return priority;}
    public void setPriority(int priority) {this.priority = priority;}
    public String toString() { return new String(processName + "," + priority);}
}
