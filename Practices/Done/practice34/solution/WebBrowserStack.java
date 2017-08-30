// Web browser history for AM session - Stack implementation

import java.util.*;

class WebPage {
  private String url;  

  public WebPage(String address) {url = address;}  
  public String toString() {return url;}
}

public class WebBrowserStack {
  private Stack<WebPage> forward; // forward stack
  private Stack<WebPage> backward; // backward stack
  private WebPage curPage = null; // current page

  public WebBrowserStack(Scanner sc) {          
    forward = new Stack<WebPage>();
    backward = new Stack<WebPage>();
    
    while (sc.hasNext()) {
      String token = sc.next();
       
      if (token.compareTo("BACKWARD") == 0) 
        moveBackward();      
      else if (token.compareTo("FORWARD") == 0)
        moveForward();      
      else
        addNewPage(token);      
    }
  }
  
  private void moveBackward() {
    if (!backward.empty()) { // can go backward
      forward.push(curPage);
      curPage = backward.pop();
    }
  }
  
  private void moveForward() {
    if (!forward.empty()) { // can go forward
      backward.push(curPage);
      curPage = forward.pop();
    }
  }
  
  private void addNewPage(String token) {
    if (curPage != null) // add to backward stack if not 1st page in browsing history
      backward.push(curPage);
    curPage = new WebPage(token);
    forward.clear(); // clear forward stack
  }

  public void print() {
    if (forward.empty() && backward.empty() && curPage == null) // no pages
      System.out.println("Browsing history is empty.");
    else {
      Stack<WebPage> tempStack = new Stack<WebPage>();
      
      System.out.println("Browsing History:");
      // print everything in backward stack -- this is reversed so need to put them in new temp stack then pop that stack
      while (!backward.empty())
        tempStack.push(backward.pop());
      while (!tempStack.empty())
        System.out.println(tempStack.pop());
      // print curPage
      System.out.println(curPage);
      // print everything in forward stack
      while (!forward.empty())
        System.out.println(forward.pop());
      System.out.println("Current Page:");
      System.out.println(curPage);
    }    
  }
  
  public static void main(String[] args) {    
    Scanner sc = new Scanner(System.in);
    WebBrowserStack bc = new WebBrowserStack(sc);

    bc.print();
  }
}
