import java.util.*;

public class DNA 
{
  private HashMap<String, Integer> dnaStrings;
  private int length;
  public void run() 
  {
    Scanner scn = new Scanner(System.in);
    int sequence = scn.nextInt();
    length = scn.nextInt();
    String dna = scn.next();
    generate(dna);
    
    int queries = scn.nextInt();
    for(int i = 0; i < queries; i++)
    {
      String input = scn.next();
      if(dnaStrings.containsKey(input))
        System.out.println(dnaStrings.get(input));
      else
        System.out.println(0);
    }
  }
  
  public void generate(String dna) 
  {
    dnaStrings = new HashMap<String, Integer>();
    for(int i = 0; i +length<= dna.length(); i++)
    {
      String sequence = dna.substring(i, i+length);
      if(!dnaStrings.containsKey(sequence))
        dnaStrings.put(sequence, 1);
      else
      {
        dnaStrings.put(sequence, dnaStrings.remove(sequence)+1);
      }
    }
  }
  
  /**
   * count   : use this method to answer one query.
   * Pre-condition :
   * Post-condition :
   */
  public int count(String substring) {
    // implementation
    return 0;
  }
  
  public static void main(String[] args) {
    DNA dna = new DNA();
    dna.run();
  }
}
