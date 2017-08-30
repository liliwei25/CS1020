import java.util.Scanner;

public class NumericSequence 
{
  public static void main(String[] args) 
  {
    Scanner sc = new Scanner(System.in);
    NumericSequence ns = new NumericSequence();
    ns.find(sc);
  }
  private void find(Scanner sc)
  {
    int mode = sc.nextInt();
    int num = sc.nextInt();
    
    int[] arr = new int[num];
    for(int i = 0; i < num; i ++)
    {
      arr[i] = sc.nextInt();
    }
    
    if(mode == 1)
    {
      sorted(arr);
    }
    else if(mode == 2)
    {
      hill(arr);
    }
  }
  private void hill(int[] arr)
  {
    int result = hill(arr, 1, 1, -1);
    if(result == -1)
      System.out.println("Not found");
    else
      System.out.println("Maximum element " + result);
  }
  private int hill(int[] arr, int index, int up, int max)
  {
    //System.out.println(arr[index-1] + " " +arr[index]);
    if(up == 1)
    {
      if(index == arr.length - 1)
      {
        max = Math.max(max, arr[index]);
          return max;
      }
      if(arr[index-1] > arr[index])
      {
        max = Math.max(max, arr[index-1]);
        return hill(arr, index + 1, 0, max);
      }
      else
      {
        max = Math.max(max, arr[index]);
        return hill(arr, index + 1, 1, max);
      }
    }
    else
    {
      if(arr[index-1] < arr[index])
      {
        return -1;
      }
      else
      {
        max = Math.max(arr[index-1], max);
        if(index == arr.length - 1)
          return max;
        else
          return hill(arr, index + 1, 0, max);
      }
    }
    //return -1;
  }
  private void sorted(int[] arr)
  {
    int result = sorted(arr, 1);
    if(result == -1)
      System.out.println("Not sorted");
    else
      System.out.println("Maximum element " + result);
  }
  private int sorted(int[] arr, int index)
  {
    if(arr[index-1] > arr[index]) return -1;
    else
    {
      if(index == arr.length - 1) return arr[index];
      else
      {
        return sorted(arr, index + 1);
      }
    }
  }
}

