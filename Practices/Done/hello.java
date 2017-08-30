import java.lang.*;
import java.util.*;

public class hello
{
  public static void main(String[] args)
  {
    int method;
    
    Scanner scn = new Scanner(System.in);
    
    method = scn.nextInt();
    
    if(method == 1)
      method1();
    else if(method == 2)
      method2();
    else method3();
  }
  
  public static void method1(void)
  {
    int number = scn.nextInt();
    int[] result;
    for(int i = 0; i < number; i++)
    {
    }
  }
  
  public static void method2(void)
  {
    String input = scn.nextLine();
    
    while(input != "0")
    {
      
  