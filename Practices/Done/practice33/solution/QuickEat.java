 // This program helps staff manage customers'
 // orders and decide who should be given a ready dish.

import java.util.*;

// This class represents all orders of customers
class ListOrder {
    
    // Data member
    private int numDishes;
    // All dishes which the restaurant offers
    private String[] dishes;
    // Each dish has a queue of customers who ordered this dish
	// All such queues are put inside an ArrayList called dishQueues
    private ArrayList<Queue<Integer>> dishQueues;
    
    // Constructor
    public ListOrder(int numDishes, Scanner sc) {
        
        this.numDishes = numDishes;
        dishes = new String[numDishes];
		// Read names of dishes
        for (int i=0; i<numDishes; i++) {
            dishes[i] = sc.nextLine();
        }
        dishQueues = new ArrayList<Queue<Integer>>();
        for (int i=0; i<numDishes; i++) {
            dishQueues.add(new LinkedList<Integer>());
        }
    }
    
    // Add new order to the list
    public void addNewOrder(int dishID,int tag) {
        dishQueues.get(dishID-1).offer(tag);
    }
    
    // Process food when it is ready
    // Return the customer who currently ordered for the dish
    // if there is no customer order for this dish return -1
    public int processReadyFood(int dishID) {
        if (dishQueues.get(dishID-1).isEmpty())
            return -1;
        else
            return dishQueues.get(dishID-1).poll();
    }
    
    // Get dish's name
    public String getDishName(int dishID) {
        return dishes[dishID-1];
    }
}

public class QuickEat {

    public static void main(String [] args) {
        
        Scanner sc = new Scanner(System.in);
        int numDishes = sc.nextInt();
        sc.nextLine();
        
        // Create the list order of food
        ListOrder listOrder = new ListOrder(numDishes, sc);
        
        int noOfCommands = sc.nextInt();
        sc.nextLine();
        
        // Process commands
        for (int i=0; i<noOfCommands; i++) {
            String input = sc.nextLine();
            
            Scanner scanner = new Scanner(input);
            String command = scanner.next();

            // Process "order" command
            if (command.equals("Order")) {
                int tagNumber = scanner.nextInt();
                int numOfOrders = scanner.nextInt();
                for (int j=0; j<numOfOrders; j++) {
                    listOrder.addNewOrder(scanner.nextInt(), tagNumber);
                }
            }

            // Process "ready" command
            if (command.equals("Ready")) {
                int dishID = scanner.nextInt();
                int tag = listOrder.processReadyFood(dishID);
                
                if (tag!=-1)
                    System.out.println(listOrder.getDishName(dishID)+" ready to be served to Tag " + tag + ".");
                else
                    System.out.println("Throw away " + listOrder.getDishName(dishID) + ".");
            }
        }
    }
}
