// Web browser history for AM session

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
 // added
 private ListNode <E> tail = null;  
 private ListNode <E> cur = null;

 public boolean isEmpty() { return (head == null); }
 
 public E getFirst() throws NoSuchElementException {
  if (head == null) 
   throw new NoSuchElementException("can't get from an empty list");
  else return head.getElement();
 }

 public ListNode <E> getHead() { return head; }

 // added
 public ListNode <E> getCur() {return cur;}
 
 public void setCur(ListNode <E> current) {cur = current;}

 public ListNode<E> addAfter(ListNode <E> current, E item) {
   ListNode<E> temp;

   if (current != null) { // insert after current
     current.setNext(new ListNode <E> (item, current.getNext()));
     cur = tail = current.getNext(); // set cur and tail         
   }
   else { // insert item at front
     head = new ListNode <E> (item, head);
     cur = tail = current = head; // set cur, tail and current     
   }
   // remove all nodes after new node
   if (cur.getNext() != null)
     cur.setNext(null);

   return cur;
 }
 
 public void print() {
  if (head == null)
   System.out.println("Browsing history is empty.");
  else {
    ListNode <E> ln = head;
    System.out.println("Browsing History:");  
    // added
    System.out.println(ln.getElement());
    
    while (ln.getNext() != null) {
      ln = ln.getNext();
      System.out.println(ln.getElement());
    }
    System.out.println("Current Page:");
    System.out.println(cur.getElement());
  }  
 }
 // end added  
}

class WebPage {
  private String url;  

  public WebPage(String address) {url = address;}  
  public String toString() {return url;}
}

public class WebBrowserLL {
  private LinkedList<WebPage> history;
  
  public WebBrowserLL(Scanner sc) {  
    ListNode<WebPage> curPage = null;
    
    history = new LinkedList<WebPage>();
    while (sc.hasNext()) {
      String token = sc.next();
       
      if (token.compareTo("BACKWARD") == 0) {
        curPage = movebackward();
      }
      else if (token.compareTo("FORWARD") == 0) {
        curPage = moveforward();
      }
      else { // add webpage to linked list
        curPage = addPage(token,curPage);
      }
    }    
  }
  
  private ListNode<WebPage> movebackward() {
    ListNode<WebPage> head = history.getHead();
    ListNode<WebPage> cur = history.getCur();
    
    if (cur != head) { // still can move backwards    
      while (head.getNext() != cur)
        head = head.getNext();     
      cur = head;
      history.setCur(cur);
    }
    return cur;
  }

  private ListNode<WebPage> moveforward() {       
    ListNode<WebPage> cur = history.getCur();
    
    if (cur != null && cur.getNext() != null) { // still can move forward
      cur = cur.getNext();
      history.setCur(cur);
    }
    return cur;
  }

  private ListNode<WebPage> addPage(String token, ListNode<WebPage> curPage) {
    WebPage newpage = new WebPage(token);

    return history.addAfter(curPage,newpage);
  }

  public void print() {
    history.print();   
  }
  
  public static void main(String[] args) {    
    Scanner sc = new Scanner(System.in);
    WebBrowserLL bc = new WebBrowserLL(sc);
    
    // print out current page id
    // print out pages in the history from earliest to the latest
    bc.print();
  }
}
