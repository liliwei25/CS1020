import java.util.*;

public class Box
{
  public void run()
  {
    Scanner scn = new Scanner(System.in);
    
    int numOfItems = scn.nextInt();
    Item[] items = new Item[numOfItems];
    for(int i = 0; i < numOfItems; i ++)
    {
      items[i] = new Item(scn.nextInt(), scn.nextInt());
    }
    int W = scn.nextInt();
    int K = scn.nextInt();
    Result max = findMaxSpaceWeight(items,W, K);
    System.out.println(max);
  }
  public static void main(String args[])
  {
    Box storage = new Box();
    storage.run();
  }
  public Result findMaxSpaceWeight(Item[] items, int W, int K) 
  {
    int count = 0;
    Result max = new Result(0, 0);
    Result temp;
    Item[] temps = new Item[items.length-1];
    for(int i = 0; i < items.length; i++)
    {
      for(int n = 0; n < items.length; n++)
        if(n != i) temps[count++] = items[n];
     count = 0;
     temp = findMaxSpaceWeight(temps, W, K, new Result(items[i].getWidth(), items[i].getWeight()));
     if(max.compareTo(temp) == -1)
       max = temp;
    }
    return max;
  } // recurse using an overloaded private method if it helps you
  private Result findMaxSpaceWeight(Item[] items, int W, int K, Result current)
  {
    if(items.length == 0) return current;
    int count = 0;
    Item[] temps = new Item[items.length-1];
    
    for(int i = 0; i < items.length; i ++)
    {
      for(int n = 0; n < items.length; n++)
        if(n != i)
        temps[count++] = items[n];
      count = 0;
      if(current.getTotalWidth() + items[i].getWidth() > W)
        return current;
      if(current.getTotalWeight() + items[i].getWeight() > K)
        return current;
      return findMaxSpaceWeight(temps, W, K, new Result(current.getTotalWidth() + items[i].getWidth(), current.getTotalWeight() + items[i].getWeight()));
    }
    return current;
  }
}
class Result implements Comparable<Result> 
{
  private int totalWidth;
  private int totalWeight;
  public Result(int wd, int wt) { totalWidth = wd; totalWeight = wt; }
  public int getTotalWidth() { return totalWidth; }
  public int getTotalWeight() { return totalWeight; }
  public String toString() {
    return "Width=" + totalWidth + ", Weight=" + totalWeight;
  }
  public int compareTo(Result other) 
  { 
    if(this.totalWidth > other.totalWidth)
      return 1;
    else if(this.totalWidth == other.totalWidth)
    {
      if(this.totalWeight > other.totalWeight)
        return 1;
      else if(this.totalWeight == other.totalWeight)
        return 0;
      else return -1;
    }
    else return -1;
  }
}
class Item 
{
  private int width;
  private int weight;
  public Item(int wd, int wt) { width = wd; weight = wt; }
  public int getWidth() { return width; }
  public int getWeight() { return weight; }
}