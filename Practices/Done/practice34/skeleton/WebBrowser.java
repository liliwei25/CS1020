import java.util.*;

public class WebBrowser {
  private Stack<String> history = new Stack<String>();
  private Stack<String> forward = new Stack<String>();
  private String current;
  private String[] output;
  public WebBrowser(Scanner sc) 
  {
    while(sc.hasNext())
    {
      String input = sc.nextLine();
      if(input.equals("FORWARD"))
      {
        if(!forward.empty())
        {
          history.push(current);
          current = forward.pop();
        }
      }
      else if(input.equals("BACKWARD"))
      {
        if(!history.empty())
        {
          forward.push(current);
          current = history.pop();
        }
      }
      else
      {
        while(!forward.empty())
          forward.pop();
        if(current!= null)
          history.push(current);
        current = input;
      }
    }
    forward.push(current);
    while(!history.empty())
      forward.push(history.pop());
    System.out.println("Browsing History: ");
    while(!forward.empty())
      System.out.println(forward.pop());
    System.out.println("Current Page: ");
    System.out.println(current);
  }

  public static void main(String[] args) {         
    Scanner sc = new Scanner(System.in);     
    WebBrowser bc = new WebBrowser(sc);
  }
}
