import java.util.*;

class Prime
{
  private String prime(int number, String curr, int factor, int power)
  {
    if(number == 1) 
    {
      if(power >1) curr +=(factor + "^" + power);
      else if(power==1) curr+= factor;
      return curr;
    }
    else
    {
      int temp = number/factor;
      if(temp*factor == number)
      {
        return prime(temp, curr, factor, power+1);
      }
      else
      {
        if(power == 1) curr+= (factor + " * ");
        else if(power> 1) curr+= (factor + "^" + power + " * ");
        return prime(number, curr, factor+1, 0);
      }
    }
  }
  private String prime(int number)
  {
    return prime(number, number+" = ", 2, 0);
  }
  private void run()
  {
    Scanner scn = new Scanner(System.in);
    System.out.println(prime(scn.nextInt()));
  }
  public static void main(String args[])
  {
    Prime newThis = new Prime();
    newThis.run();
  }
}