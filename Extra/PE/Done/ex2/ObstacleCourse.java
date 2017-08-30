import java.util.Scanner;

public class ObstacleCourse 
{
  public static int countHops(Block[] blocks, int currIndex) 
  {
    return countHops(blocks, currIndex, 0);
  }
  public static int countHops(Block[] blocks, int currIndex, int jumps)
  {
    if(currIndex == blocks.length-1) return jumps;
    else
    {
      int counter = 2;
      int result = countHops(blocks, currIndex+1, jumps+1);
      while(counter + currIndex < blocks.length && blocks[currIndex].getHoppingRange() >= blocks[currIndex+ counter].getHeight())
      {
        result = Math.min(result, countHops(blocks, currIndex+ counter, jumps+1));
        counter++;
      }
      return result;
    }
  }
  public static void main(String[] args) 
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Block[] blocks = new Block[n];
    for (int i = 0; i < n; i++) {
      blocks[i] = new Block(sc.nextInt(), sc.nextInt());
    }
    System.out.println(countHops(blocks, 0));
  }
  
}

class Block 
{
  private int height;
  private int hoppingRange;
  
  public Block(int height, int hoppingRange) {
    this.height = height;
    this.hoppingRange = hoppingRange;
  }
  
  public int getHeight() {
    return this.height;
  }
  
  public int getHoppingRange() {
    return this.hoppingRange;
  }
}