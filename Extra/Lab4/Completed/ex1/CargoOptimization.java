import java.util.*;

public class CargoOptimization 
{
 private ArrayList<Stack<Container>> stacks; // use an array list to represent the stacks in the terminal
 public CargoOptimization() { stacks = new ArrayList<Stack<Container>>(); }
 
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  CargoOptimization optimizer = new CargoOptimization();
  
  optimizer.stacks.add(new Stack<Container>());
  // complete the program
  String input = sc.next();
  for(int i = 0; i < input.length(); i++)
  {
    optimizer.processContainer(input.charAt(i));
  }
  System.out.println(optimizer.getNumOfStacks());
 }
 
 public int getNumOfStacks() { return stacks.size(); }
 
 public void processContainer(char ship) 
 {
   Container temp = new Container(ship);
   if(stacks.get(0).empty()) 
   {
     stacks.get(0).push(temp); 
     return;
   }
   if(findBestStack(temp) != -1)
     stacks.get(findBestStack(temp)).push(temp);
   else
   {
     stacks.add(new Stack<Container>());
     stacks.get(stacks.size()-1).push(temp);
   }
  
 }
 private int findBestStack(Container newArrival) 
 {
   int temp = -1;
   for(int i = 0 ; i < stacks.size(); i++)
   {
     if(newArrival.calculateFitWith(stacks.get(i))==1) return i;
     else if(temp == -1 && newArrival.calculateFitWith(stacks.get(i)) == 0)
       temp = i;
   }
   return temp;
 }
}
class Container {
 private char destination;
 public Container(char destination) { this.destination = destination; }

 public int calculateFitWith(Stack<Container> candidate) 
 {
   if(candidate.peek().destination == this.destination)
     return 1;
   else if(candidate.peek().destination > this.destination)
     return 0;
   else return -1;
 }
}