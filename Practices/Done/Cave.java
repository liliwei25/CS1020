import java.util.*;

class Cave
{
  private ArrayList<ArrayList<Integer>> grid;
  private void run()
  {
    Scanner scn = new Scanner(System.in);
    
    int rows = scn.nextInt();
    int cols = scn.nextInt();
    
    grid = new ArrayList<ArrayList<Integer>>(rows);
    for(int i = 0; i < rows; i++)
    {
      grid.add(i, new ArrayList<Integer>(cols));
      for(int n = 0; n < cols; n++)
      {
        grid.get(i).add(n, scn.nextInt());
      }
    }
    int queries = scn.nextInt();
    for(int i = 0; i < queries; i++)
    {
      String input = scn.next();
      if(input.equals("swap"))
      {
        int x1 = scn.nextInt() - 1;
        int y1 = scn.nextInt() - 1;
        int x2 = scn.nextInt() - 1;
        int y2 = scn.nextInt() - 1;
        int numRows = scn.nextInt();
        int numCols = scn.nextInt();
        
        for(int n = 0; n < numRows; n++)
        {
          ArrayList<Integer> swap1 = new ArrayList<Integer>();
          swap1.addAll(grid.get(x1+n).subList(y1, y1 + numCols));
          ArrayList<Integer> swap2 = new ArrayList<Integer>();
          swap2.addAll(grid.get(x2+n).subList(y2, y2 + numCols));
          
          grid.get(x1+n).subList(y1, y1 + numCols).clear();
          grid.get(x1+n).addAll(y1, swap2);
          grid.get(x2+n).subList(y2, y2 + numCols).clear();
          grid.get(x2+n).addAll(y2, swap1);
        }
      }
      else if(input.equals("print"))
      {
        for(int n = 0; n < rows; n++)
        {
          for(int j = 0; j < cols; j++)
          {
            System.out.print(grid.get(n).get(j) + " ");
          }
          System.out.println();
        }
      }
    }
  }
  public static void main(String[] args)
  {
    Cave cave = new Cave();
    cave.run();
  }
}