import java.util.*;

class Digit 
{
  // Data attributes
  private int digit;
  private Digit next;
  
  // Constructors
  public Digit(int digit, Digit next) {
    this.digit = digit;
    this.next = next;
  }
  
  // Accessors
  public int getDigit() {return digit;}
  public Digit getNext() {return next;}
  public void setDigit(int digit) {this.digit = digit;}
  public void setNext(Digit next) {this.next = next;}
}

// Added the tail attribute and updated the methods accordingly
// Added a recursive version of sum
class BigNumber 
{
  private Digit head = null;
  private Digit tail = null;
  private int length = 0;
  
  // Constructors
  // Build a linked list of digits
  public BigNumber(String number) 
  {
    tail = head = new Digit(number.charAt(number.length()-1));
    for(int i = number.length()-2; i >= 0; i--)
    {
      tail.setNext(new Digit(number.charAt(i), null));
      tail = tail.getNext();
    }
    length = number.length();
  }
  public Digit getHead() {return head;}
  public int getLength() {return length;}
  // Append a digit to the linked list
  public void add(int digit) 
  {
    if(head == null) 
    {
      head = new Digit(digit, null);
      tail = head;
    }
    else
    {
      head = new Digit(digit, head);
    }
    length++;
  }
  public Digit getTail() {return tail;}
  // Sum two big numbers recursively and return its sum
  public static String sumRecursive(BigNumber n1, BigNumber n2) 
  {
    return sumRecursive(n1.head, n2.head, "", 0);
  }
  public static String sumRecursive(Digit n1, Digit n2, String sum, int carry)
  {
    if(n1 == null || n2 == null) 
    {
      if(n2 != null)
      {
        if(carry!= 0) sum = (carry + n2.getDigit()) + sum;
        while(n2 != null)
        {
          sum = n2.getDigit() + sum;
          n2 = n2.getNext();
        }
      }
      if(n1!= null)
      {
        if(carry!= 0) sum = (carry + n1.getDigit()) + sum;
        while(n1!= null)
        {
          sum = n1.getDigit()+sum;
          n1 = n1
        }
      }
      return sum;
    }
    else
    {
      if(n1.getDigit()
    }
  }
  public String toString() 
  {
    Digit curr = head;
    String output = ""+ curr.getDigit();
    for(int i = 0; i < this.length; i++)
    {
      output+= curr.getDigit();
      curr = curr.getNext();
    }
    return output;
  }
}

public class TestBigNumber {
  
  public static void main(String[] args) {
    // Declare a Scanner object to read input
    
    // Declare the necessary variables
    
    // Read input and process them accordingly
    
    // Output the result
    // Ensure your output is in the right format
    
  }
}
