/**
 * Name          :
 * Matric number :
 */

import java.util.*;

public class Cake {
 public static void main(String[] args) {
  Scanner scn = new Scanner(System.in);
  
  int num = scn.nextInt();
  int tolerance = scn.nextInt();
  
  Queue<Slice> cake = new LinkedList<Slice>();
  Slice temp;
  int max = 0;
  int curr = 0;
  int currR = 0;
  for(int i = 0; i < num; i++)
  {
    temp = new Slice(scn.next().charAt(0), scn.nextInt());
    cake.offer(temp);
    if(temp.hasRaisins()) currR++;
    curr += temp.getChoc();
    if(currR > tolerance)
    {
      while(currR > tolerance)
      {
        temp = cake.poll();
        if(temp.hasRaisins()) currR--;
        curr -= temp.getChoc();
      }
    }
    
    //if(currR <= tolerance)
    //{
      max = Math.max(curr, max);
    //}
  }
  System.out.println(max);
 }
}
class Slice
{
  private int choc;
  private char raisins;
  public Slice(char raisins, int choc)
  {
    this.choc = choc;
    this.raisins = raisins;
  }
  public int getChoc(){return choc;}
  public boolean hasRaisins()
  {
    return (raisins == 'R');
  }
}
