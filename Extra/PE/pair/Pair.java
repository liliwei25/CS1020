import java.util.*;

public class Pair 
{
  ArrayList<Group> groupings;
  private void run()
  {
    Scanner scn = new Scanner(System.in);
    int numOfP = scn.nextInt();
    
    int[] participants = new int[numOfP];
    for(int i = 0; i < numOfP; i++)
    {
      participants[i] = scn.nextInt();
    }
    groupings = new ArrayList<Group>();
    for(int i = 0; i < numOfP; i++)
    {
      for(int n = 0; n < numOfP; n++)
      {
        if(n==i) continue;
        else
        {
          groupings.add(new Group(participants[i], participants[n]));
        }
      }
    }
    int total = 0;
    for(int i = 0; i < groupings.size(); i++)
    {
      for(int n = 0; n < groupings.size(); n++)
      {
        if(i == n) continue;
        else
        {
          
          if(groupings.get(i).equalStrength(groupings.get(n)))
            total++;
          //System.out.println(groupings.get(i) + " " + groupings.get(n) +" "  + total);
        }
      }
    }
    System.out.println(total);
  }
  public static void main(String[] args) 
  {
    Pair newPair = new Pair();
    newPair.run();
  }
}
class Group
{
  private int leader;
  private int member;
  
  public Group(int leader, int member)
  {
    this.leader = leader;
    this.member = member;
  }
  public int getLeader(){return leader;}
  public int getMember(){return member;}
  public boolean equalStrength(Group opponent)
  {
    if(this.leader == opponent.leader || this.leader == opponent.member || this.member == opponent.leader || this.member == opponent.member)
      return false;
    return (this.leader + this.member == opponent.leader+opponent.member);
  }
  public String toString()
  {
    return ("(" + leader+", "+ member+")");
  }
}
