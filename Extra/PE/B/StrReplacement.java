import java.util.*;

public class StrReplacement 
{
  private void run()
  {
    Scanner scn = new Scanner(System.in);
    
    int mode = scn.nextInt();
    
    String input = scn.next();
    if(mode == 1)
      System.out.println(replace(input, scn.next().charAt(0)));
    else if(mode == 2)
      System.out.println(replace(input, scn.next()));
    else if(mode == 3)
    {
      String key = findCommon(input.clone(), scn.next());
      System.out.println(key + "  hello");
      System.out.println(replace(input, key));
    }
  }
  private String findCommon(String input, String key)
  {
    return findCommon(input, key, "", 0);
  }
  private String findCommon(String input, String key, String common, int index)
  {
    
  }
  private String replace(String input, String replacement)
  {
    return replace(input, replacement, "");
  }
  private String replace(String input, String replacement, String output)
  {
    if(input.length() == 0 || replacement.length() == 0) return output;
    else
    {
      if(input.length() >= replacement.length() && input.charAt(0) == replacement.charAt(0))
      {
        if(same(input.substring(0, replacement.length()), replacement))
          return replace(input.substring(replacement.length(), input.length()), replacement, output + " ");
      }
      return replace(input.substring(1, input.length()), replacement, output + input.charAt(0));
    }
  }
  private boolean same(String input, String key)
  {
    for(int i = 0; i < input.length(); i++)
    {
      if(input.charAt(i)!= key.charAt(i))
        return false;
    }
    return true;
  }
  private String replace(String input, char replacement)
  {
    return replace(input, replacement, "");
  }
  private String replace(String input, char replacement, String output)
  {
    if(input.length() == 0) return output;
    else
    {
      if(input.charAt(0) == replacement)
      {
        return replace(input.substring(1, input.length()), replacement, output+ " ");
      }
      else
      {
        return replace(input.substring(1, input.length()), replacement, output + input.charAt(0));
      }
    }
  }
  public static void main(String[] args) 
  {
    StrReplacement newThis = new StrReplacement();
    newThis.run();
  }
}