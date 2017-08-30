import java.util.*;

public class Radiation {

 public void run() {
  Scanner scn = new Scanner(System.in);
  int num = scn.nextInt();
  int max = 0;
  Stack<Element> stock = new Stack<Element>();
  for(int i = 0; i < num; i ++)
  {
    int input = scn.nextInt();
    if(stock.empty())
      stock.push(new Element(input, 0));
    else
    {
      if(input > stock.peek().getStrength())
      {
        stock.push(new Element(input, 1));
        max = Math.max(max, 1);
      }
      else
      {
        int currMax = 0;
        while(!stock.empty() &&input <= stock.peek().getStrength())
        {
          currMax = Math.max(currMax, stock.pop().getYears());
        }
        if(stock.empty()) stock.push(new Element(input, 0));
        else
        {
          stock.push(new Element(input, currMax+1));
          max = Math.max(max, currMax+1);
        }
      }
    }
  }
  System.out.println(max);
 }

 public static void main(String[] args) {
  Radiation myChemicalElements = new Radiation();
  myChemicalElements.run();
 }
}

// hint for O(N) solution...
class Element {
 private int strength;
 private int yearsBeforeDecay;

 public Element(int strength, int yearsBeforeDecay) {
  this.strength = strength;
  this.yearsBeforeDecay = yearsBeforeDecay;
 }

 public int getStrength() {
  return this.strength;
 }

 public int getYears() {
  return this.yearsBeforeDecay;
 }
}
