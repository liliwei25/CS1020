import java.util.*;

class Find 
{
  private HashMap<String, Integer> sequences;
  private int length;
  public void run()
  {
    Scanner scn = new Scanner(System.in);
    int dnaLength = scn.nextInt();
    length = scn.nextInt();
    String dna1 = scn.next();
    String dna2 = scn.next();
    
    sequences = new HashMap<String, Integer>();
    process(dna1, 1);
    process(dna2, 2);
    
    int queries = scn.nextInt();
    for(int i = 0; i < queries; i++)
    {
      String input = scn.next();
      if(sequences.containsKey(input))
        System.out.println(sequences.get(input));
      else
        System.out.println(0);
    }
  }
  private void process(String dna, int key)
  {
    for(int i = 0; i + length <= dna.length(); i++)
    {
      String subseq = dna.substring(i, i+length);
      if(!sequences.containsKey(subseq))
        sequences.put(subseq, key);
      else
      {
        if(key == 2 && sequences.get(subseq) == 1)
        {
          sequences.put(subseq, sequences.remove(subseq) + 2);
        }
      }
    }
  }
  public static void main(String[] args) 
  {
    Find finder = new Find();
    finder.run();
  }
}