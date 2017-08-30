// Parser for PM session

import java.util.*;

class ListNode <E> {
 /* data attributes */
 private E element;
 private ListNode <E> next;

 /* constructors */
 public ListNode(E item) { this(item, null); }

 public ListNode(E item, ListNode <E> n) { 
  element = item; 
  next = n;
 }

 /* get the next ListNode */
 public ListNode <E> getNext() { return next; }

 /* get the element of the ListNode */
 public E getElement() { return element; }

 /* set the next reference */
 public void setNext(ListNode <E> n) { next = n; }
}

class LinkedList <E> {
 private ListNode <E> head = null;
 private int num_nodes = 0;

 public boolean isEmpty() { return (num_nodes == 0); }

 public int size() { return num_nodes; }

 // added
 public void addFirst(E item) {
  head = new ListNode <E> (item, head); 
  num_nodes++;
 }

 public E getFirst() { return head.getElement(); }
 
 public ListNode <E>  removeFirst() { 
   ListNode <E>  temp;
   
   temp = head;
   head = head.getNext();
   temp.setNext(null);
   num_nodes--;
   
   return temp;
 }
}

class Token {
  private String tag;
  private int id;
  
  public Token (String itag, int identity) {tag = itag; id = identity;}
  public String getTag() {return tag;}
  public int getID() {return id;}
}

public class ParserLL {
  private static final Token[] OpenTags= {new Token("<S>",0),new Token("<P>",1),new Token("<B>",2),new Token("<I>",3)};
  private static final Token[] CloseTags= {new Token("</S>",0),new Token("</P>",1),new Token("</B>",2),new Token("</I>",3)};
  private static final Token[] OtherTags= {new Token("<LB>",5),new Token("<PB>",6),new Token("<TEXT>",7)};
  
  private LinkedList<Token> tokenLL;
  private boolean error;
  
  public ParserLL(Scanner sc) {
    tokenLL = new LinkedList<Token> ();    

    error = false;
    while (sc.hasNext()) {
      String token = sc.next();
      Boolean isOpenTag, isCloseTag;

      isOpenTag = isCloseTag = false;
      // check if opening tag
      for (int i=0; i < 4; i++)
        if (token.compareTo(OpenTags[i].getTag()) == 0) {
          tokenLL.addFirst(OpenTags[i]);
          isOpenTag = true;
          break;  
        }
      if (!isOpenTag) {// check if closing tag
        for (int i=0; i < 4; i++)
          if (token.compareTo(CloseTags[i].getTag()) == 0) {
            if (!tokenLL.isEmpty()) {              
              if (tokenLL.getFirst().getID() != CloseTags[i].getID())  // check if top of stack is corresponding open tag
                error = true;
              else
                tokenLL.removeFirst();
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
    if (!tokenLL.isEmpty()) // check if stack is empty at the end
      error = true;
  }
  
  public boolean isError() {return error;}
  
  public static void main(String[] args) { 
    Scanner sc = new Scanner(System.in);
    ParserLL parser = new ParserLL(sc);
    
    if (parser.isError())
      System.out.println("Error!");
    else
      System.out.println("No Error");
  }
}
