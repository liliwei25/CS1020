import java.util.*;

class StringReversal {
  
  public StringReversal(Scanner sc) 
  {  
    String input = sc.next();
    System.out.println(reverse(input));
  }
  private String reverse(String input)
  {
    return reverse(input, input.length()-1, "");
  }
  private String reverse(String input, int curr, String output)
  {
    if(output.length() == input.length()) return output;
    else
    {
      return reverse(input, curr-1, output+ input.charAt(curr));
    }
  }
  public static void main(String[] args) {    
    Scanner sc = new Scanner(System.in);
    StringReversal sr = new StringReversal(sc);

  }
}
