import java.util.*;

class Knapsack 
{
  private void run()
  {
    Scanner scn = new Scanner(System.in);
    int items = scn.nextInt();
    int maxWeight = scn.nextInt();
    
    int[] itemList = new int[items];
    for(int i = 0; i < items; i++)
      itemList[i] = scn.nextInt();
    System.out.println(maxItems(itemList, maxWeight, 0));
  }
  private int maxItems(int[] itemList, int max, int index)
  {
    if(max < 0) return 0;
    if(max == 0) return 1;
    if(index >= itemList.length) return 1;
    else
    {
      return maxItems(itemList, max, index + 1) + maxItems(itemList, max - itemList[index], index + 1);
    }
  }
  public static void main(String[] args) 
  {
    Knapsack sack = new Knapsack();
    sack.run();
  }
}