// Parser for PM session

import java.util.*;

class Token {
  private String tag;
  private int id;
  
  public Token (String itag, int identity) {tag = itag; id = identity;}
  public String getTag() {return tag;}
  public int getID() {return id;}
}

public class ParserStack {
  private static final Token[] OpenTags= {new Token("<S>",0),new Token("<P>",1),new Token("<B>",2),new Token("<I>",3)};
  private static final Token[] CloseTags= {new Token("</S>",0),new Token("</P>",1),new Token("</B>",2),new Token("</I>",3)};
  private static final Token[] OtherTags= {new Token("<LB>",5),new Token("<PB>",6),new Token("<TEXT>",7)};
  
  private Stack<Token> tokenStack;
  private boolean error;
  
  public ParserStack (Scanner sc) {        
    tokenStack = new Stack<Token> ();    

    error = false;
    while (sc.hasNext()) {
      String token = sc.next();
      Boolean isOpenTag, isCloseTag;
      
      isOpenTag = isCloseTag = false;
      // check if opening tag
      for (int i=0; i < 4; i++)
        if (token.compareTo(OpenTags[i].getTag()) == 0) {
          tokenStack.push(OpenTags[i]);
          isOpenTag = true;
          break;  
        }
      if (!isOpenTag) {// check if closing tag
        for (int i=0; i < 4; i++)
          if (token.compareTo(CloseTags[i].getTag()) == 0) {
            if (!tokenStack.empty()) {              
              if (tokenStack.peek().getID() != CloseTags[i].getID())  // check if top of stack is corresponding open tag
                error = true;
              else
                tokenStack.pop();
            }
            else
              error = true;
            isCloseTag = true;
            break;  
          }
      }
      if (!error && !isOpenTag && !isCloseTag) { // check if valid other tag
        error = true;
        for (int i=0; i < 3; i++)
          if (token.compareTo(OtherTags[i].getTag()) == 0) {
            error = false;
            break;
          }
      }
      if (error)
        break;
    }    
    if (!tokenStack.empty()) // check if stack is empty at the end
      error = true;    
  }
  
  public boolean isError() {return error;}
  
  public static void main(String[] args) { 
    Scanner sc = new Scanner(System.in);
    ParserStack parser = new ParserStack(sc);
    
    if (parser.isError())
      System.out.println("Error!");
    else
      System.out.println("No Error");
  }
}
