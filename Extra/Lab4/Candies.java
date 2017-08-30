import java.util.*;

public class Candies
{
  private Stack<Child> queue = new Stack<Child>();
  
  private void run()
  {
    Scanner scn = new Scanner(System.in);
    
    int num = scn.nextInt();
    
    for(int i = 0; i < num ; i++)
    {
      int input = scn.nextInt();
      if(queue.empty()) queue.push(new Child(input));
      else
      {
        
      }
    }
  }
  public static void main(String args[])
  {
    Candies newThis = new Candies();
    newThis.run();
  }
}
class Child
{
  private int rating;
  private int candies;
  
  public Child(int rating)
  {
    this.rating = rating;
    candies = 0;
  }
  public int getRating(){return rating;}
  public int getCandies(){return candies;}
  public void setCandies(int candies){this.candies = candies;}
}