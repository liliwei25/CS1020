import java.util.*;
import java.awt.Point;

class ShortestPath {
  public static void main(String[] args) {
    int[][] maze;
    Scanner sc = new Scanner(System.in);
    
    //Take in inputs
    int N = sc.nextInt();
    maze = new int[N][N];
    
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        maze[i][j] = sc.nextInt();
      }
    }
    
    // Starting location is at maze[1][0];
    Stack<Point> shortestPath = pathfinder(maze, 1, 0, new Stack<Point>());
    
    System.out.println("The shortest path is " + shortestPath.size() + " steps:");
    
    // Print out the path
    printPath(shortestPath);
  }
  private static void printPath(Stack<Point> path)
  {
    Stack<Point> temp = new Stack<Point>();
    while(!path.empty())
    {
      temp.push(path.pop());
    }
    while(!temp.empty())
    {
      System.out.println("(" + (int)temp.peek().getX() + ", " + (int)temp.pop().getY() +")");
    }
  }
  //Recursive function
  public static Stack<Point> pathfinder(int[][] maze, int row, int col, Stack<Point> path) 
  {
    if(row >= maze.length || row < 0 || col >= maze.length)
      return path;
    else
    {
      maze[row][col] = 1;
      path.push(new Point(row, col));
      if(row > 0 && maze[row-1][col] != 1)
      {
        path.push(new Point(row-1, col));
        return pathfinder(maze, row-1, col, path);
      }
      if(row < maze.length - 1 && maze[row+1][col] != 1)
      {
        path.push(new Point(row-1, col));
        return pathfinder(maze, row+1, col, path);
      }
      if(col > 0 && maze[row][col-1] != 1)
      {
        path.push(new Point(row-1, col));
        return pathfinder(maze, row, col-1, path);
      }
      if(col < maze.length - 1 && maze[row][col+1] != 1)
        return pathfinder(maze, row, col+1, path);
    }
    return path;
  }
}