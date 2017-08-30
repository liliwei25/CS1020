import java.util.*;

class LPS {

  public LPS(Scanner sc) {  
    String input = sc.next();
    
    System.out.println(longestPalin(input));

  }
  private int longestPalin(String input)
  {
    return longestPalin(input, 0, "");
  }
  private int longestPalin(String input, int curr, String output)
  {
    if(curr == input.length() - 1)
    {
      if(checkPalindrome(output)) return output.length();
      else return 0;
    }
    else
    {
      return Math.max(longestPalin(input, curr + 1, output+input.charAt(curr)), longestPalin(input, curr + 1, output));
    }
  }
  private boolean checkPalindrome(String input)
  {
    for(int i = 0; i < input.length()/2; i++)
    {
      if(input.charAt(i) != input.charAt(input.length() -1 - i))
        return false;
    }
    return true;
  }
  public static void main(String[] args) {    
    Scanner sc = new Scanner(System.in);
    LPS lps = new LPS(sc);

  }
}
