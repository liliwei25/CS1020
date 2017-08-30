import java.util.*;

public class Stick 
{ 
  public static void main(String[] args) 
  {
    Stick sticks = new Stick();
    sticks.run();
  }
  private void run()
  {
    Scanner scn = new Scanner(System.in);
    int numSticks = scn.nextInt();
    int target = scn.nextInt();
    
    int[] sticks = new int[numSticks];
    for(int i = 0; i < numSticks; i++)
    {
      sticks[i] = scn.nextInt();
    }
    System.out.println(findTarget(0, 0, target, sticks, 0));
  }
  private int findTarget(int curr,int num, int target, int[] sticks,int index)
  {
    if(num == target) return curr;
    if(num > target) return -1;
    if(index >= sticks.length)
      return -1;
    else
    {
      int result1 = findTarget(curr, num, target, sticks, index + 1);
      int result2 = findTarget(curr + 1, num + sticks[index], target, sticks, index + 1);
      
      if(result2 == -1) return result1;
      else if(result1 == -1) return result2;
      else if(result2 > result1) return result1;
      else return result2;
    }
  }
}