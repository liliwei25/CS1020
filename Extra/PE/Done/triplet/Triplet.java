import java.util.*;

class Triplet 
{
  private void run()
  {
    Scanner scn = new Scanner(System.in);
    
    int number = scn.nextInt();
    int largestNeg;
    int secondNeg;
    int thirdNeg;
    int largestP;
    int secondP;
    int thirdP;
    boolean zero = false;
    largestNeg = secondNeg = thirdNeg = 999999999;
      largestP = secondP = thirdP = -999999999;
    if(largestNeg == 0) zero = true;
    for(int i = 0; i < number; i++)
    {
      int input = scn.nextInt();
      if(input == 0) zero = true;
      if(largestNeg > input)
      {
        secondNeg = largestNeg;
        largestNeg= Math.min(largestNeg, input);
      }
      else if(secondNeg >= input)
      {
        thirdNeg = secondNeg;
        secondNeg = Math.min(secondNeg, input);
      }
      else
        thirdNeg = Math.min(thirdNeg, input);
      if(largestP < input)
      {
        secondP = largestP;
        largestP = Math.max(largestP, input);
      }
      else if(secondP <= input)
      {
        thirdP = secondP;
        secondP = Math.max(input,secondP);
      }
      else
        thirdP = Math.max(input, thirdP);
    }
    //System.out.println(largestNeg +" "+ secondNeg +" "+ thirdNeg +" "+ largestP +" "+ secondP +" "+ thirdP);
    int min = Math.min(largestNeg* secondNeg * thirdNeg, largestNeg * largestP * secondP);
    if(zero) min = Math.min(min, 0);
    int max = Math.max(largestNeg*secondNeg* largestP, largestP * secondP * thirdP);
    System.out.println(min + " " + max);
  }
  public static void main(String[] args) 
  {
    Triplet newThis = new Triplet();
    newThis.run();
  }
}