import java.util.*;

/* Parser for the markup language */
public class Parser 
{
  private Stack<String> code;
  public Parser(Scanner sc) 
  {
    boolean flag = true;
    code = new Stack<String>();
    while(sc.hasNext())
    {
      String input = sc.next().trim();
      if(input.equals("<PB>") || input.equals("<LB>") || input.equals("<TEXT>"))
      {
      }
      else if (input.equals("</S>") || input.equals("</P>") || input.equals("</B>") || input.equals("</I>"))
      {
        if(code.empty())
        {
          flag = false;
          break;
        }
        flag = checkCode(input);
        if(!flag) break;      
      }
      else if (input.equals("<S>") || input.equals("<P>") || input.equals("<B>") || input.equals("<I>"))
      {
          code.push(input);
      }
      else
      {
        flag = false;
        break;
      }
    }
    if(flag)
      System.out.println("No Error");
    else
      System.out.println("Error!");
  }
  private boolean checkCode(String input)
  {
    if(input.equals("</S>"))
      input = "<S>";
    else if(input.equals("</P>"))
      input = "<P>";
    else if(input.equals("</B>"))
      input = "<B>";
    else if(input.equals("</I>"))
      input = "<I>";
    if(input.equals(code.pop()))
      return true;
    else return false;
  }
  public static void main(String[] args) {         
    Scanner sc = new Scanner(System.in);     
    Parser bc = new Parser(sc);
  }
}
