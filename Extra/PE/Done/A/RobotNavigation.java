import java.util.*;

/* class representing the Robot Navigation system */
public class RobotNavigation 
{
  private void run()
  {
    Scanner scn = new Scanner(System.in);
    
    int mode = scn.nextInt();
    
    
    if(mode == 1)
    {
      int size = scn.nextInt();
      int start = scn.nextInt();
      System.out.println(cost(scn, start, size));
    }
    else if(mode == 2)
    {
      int size = scn.nextInt();
      int startX = scn.nextInt();
      int startY = scn.nextInt();
      
      int[][] arr = new int[size][size];
      for(int i = 0; i < size; i++)
      {
        for(int n = 0; n < size; n++)
        {
          arr[i][n] = scn.nextInt();
        }
      }
      System.out.println(cost(arr, startX, startY));
    }
    else if(mode == 3)
    {
      int size = scn.nextInt();
      int startX = scn.nextInt();
      int startY = scn.nextInt();
      
      int[][] arr = new int[size][size];
      for(int i = 0; i < size; i++)
      {
        for(int n = 0; n < size; n++)
        {
          arr[i][n] = scn.nextInt();
        }
      }
      System.out.println(costMin(arr, startX, startY));
    }
  }
  private int costMin(int[][] arr, int startX, int startY)
  {
    
    //System.out.println(startX + " "  + startY);
    if(startX < 0 || startX > arr.length-1) return 999;
    if(startY < 0 || startY > arr.length-1) return 999;
    if(startX == arr.length - 1 && startY == arr.length -1)
      return arr[startX][startY];
    else
    {/*
      if(startX == arr.length -2 && startY == arr.length - 2)
        return arr[startX][startY] + cost(arr, startX + 1, startY + 1);
      else*/
        return arr[startX][startY] + Math.min(costMin(arr, startX+1, startY+1),
                        Math.min(costMin(arr, startX, startY+1), costMin(arr, startX+1, startY)));
    }
  }
  private int cost(int[][] arr, int startX, int startY)
  {
    if(startX == arr.length - 1 && startY == arr.length-1) return arr[startX][startY];
    else
    {
      if(startX == arr.length -2 && startY == arr.length - 2)
        return arr[startX][startY] + cost(arr, startX + 1, startY + 1);
      int cost1 = arr[startX][startY+1];
      int cost2 = arr[startX+1][startY];
      int cost3 = arr[startX+1][startY+1];
      if( cost1 < cost2 && cost1 < cost3)
        return arr[startX][startY] + cost(arr, startX, startY+1);
      else if(cost2 < cost1 && cost2 < cost3)
        return arr[startX][startY] + cost(arr, startX+1, startY);
      else
        return arr[startX][startY] + cost(arr, startX+1, startY+1);
    }
  }
  private int cost(Scanner scn, int start, int size)
  {
    return cost(scn, start, size, 0);
  }
  private int cost(Scanner scn, int start, int size, int curr)
  {
    if(curr >= size) return 0;
    else
    {
      if(curr >= start)
      {
        return scn.nextInt() + cost(scn, start, size, curr + 1);
      }
      else
      {
        scn.nextInt();
        return cost(scn, start, size, curr + 1);
      }
    }
  }
  public static void main(String[] args) 
  {
    RobotNavigation newThis = new RobotNavigation();
    newThis.run();
  }
}
