import java.util.*;

class Swap
{
  private char[] base;
  private void run()
  {
    Scanner scn = new Scanner(System.in);
    
    int length = scn.nextInt();
    int changes = scn.nextInt();
    
    char[] number = scn.next().toCharArray();
    base = scn.next().toCharArray();
    
    System.out.println(findMax(number, changes, 1));
  }
  private int findMax(char[] number, int curr, int index)
  {
    if(curr == 0) return calculateProduct(number);
    if(index >= number.length+1) return calculateProduct(number);
    else
    {
      return Math.max(findMax(number,  curr, index + 1), findMax(swap(index, number.clone()),  curr-1, index+1));
    }
  }
  private char[] swap(int x, char[] num)
  {
    char temp = num[0];
    num[0] = num[x-1];
    num[x-1] = temp;
    return num;
  }
  private int calculateProduct(char[] num)
  {
    int sum = 0;
    for(int i = 0; i < num.length; i++)
    {
      sum += (Character.getNumericValue(num[i]) * Character.getNumericValue(base[i]));
    }
    return sum;
  }
  public static void main(String[] args)
  {
    Swap newSwap = new Swap();
    newSwap.run();
  }
}