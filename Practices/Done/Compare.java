import java.lang.*;
import java.util.*;

public class Compare
{
  public static void main (String[] args)
  {
    String line1, line2;
    int sum1=0, sum2=0;
  
    Scanner scn = new Scanner(System.in);
    
    line1 = scn.nextLine();
    line2 = scn.nextLine();
    
    int result = line1.compareToIgnoreCase(line2);
    
    if(result == 0) System.out.println("0");
    else if(result < 0) System.out.println("1");
    else System.out.println("2");
  }
}