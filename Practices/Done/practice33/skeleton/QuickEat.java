import java.util.*;

public class QuickEat {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int numDishes = sc.nextInt();
        sc.nextLine();
        
        ListOrder listOrder = new ListOrder(numDishes, sc);

        int noOfCommands = sc.nextInt();
 
        String input;
      
        // Process commands
        for(int i = 0; i < noOfCommands; i++)
        {
          input = sc.next();
          if(input.equals("Order"))
          {
            int id = sc.nextInt();
            int dishes = sc.nextInt();
            for(int n = 0; n < dishes; n++)
              listOrder.addNewOrder(sc.nextInt(), id);
          }
          else
          {
            int food = sc.nextInt();
            int id = listOrder.processReadyFood(food);
            if(id == -1)
              System.out.println("Throw away " + listOrder.getDishName(food));
            else
              System.out.println(listOrder.getDishName(food) + " ready to be served to Tag " + id);
          }
        }
    }
}
class ListOrder {
    private int numDishes;
    private String[] dishes;
    private ArrayList<Queue<Integer>> dishQueues;
    
    public ListOrder(int numDishes, Scanner sc) {
      dishQueues = new ArrayList<Queue<Integer>>();
      dishes = new String[numDishes];
      this.numDishes = numDishes;
      for(int i = 0; i < numDishes; i++)
      {
        dishes[i] = sc.nextLine();
        dishQueues.add(new LinkedList<Integer>());
      }
    }
    public void addNewOrder(int dishID, int tag) 
    {
      dishQueues.get(dishID-1).offer(tag);
    }
    public int processReadyFood(int dishID) {
      if(dishQueues.get(dishID-1).peek() == null)
        return -1;
      else
        return dishQueues.get(dishID-1).poll();
    }
    public String getDishName(int dishID) {
      return dishes[dishID-1];
    }
}