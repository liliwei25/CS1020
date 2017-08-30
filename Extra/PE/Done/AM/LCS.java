import java.util.*;

class LCS 
{
  public LCS(Scanner sc) 
  {  
    String input1 = sc.next();
    String input2 = sc.next();
    
    System.out.println(substring(input1, input2));
  }  
  private int substring(String input1, String input2)
  {
    return substring(input1, input2, "");
  }
  private int substring(String input1, String input2, String curr)
  {
    if(input1.length() == 0 || input2.length() == 0) 
    {
      //System.out.println(curr);
      return curr.length();
    }
      else
    {
      int index = input2.indexOf(input1.charAt(0));
      if(index!= -1)
      {
        
        return substring(input1.substring(1, input1.length()), input2.substring(index + 1, input2.length()), curr + input1.charAt(0));
      }
      else
      {
        return substring(input1.substring(1, input1.length()), input2, curr);
      }
    }
  }
  public static void main(String[] args) {    
    Scanner sc = new Scanner(System.in);
    LCS lcs = new LCS(sc);

  }
}
