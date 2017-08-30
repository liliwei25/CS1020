public class Bucket
{
  public static void printMatrix(int[][] matrix)
  { 
    for (int[] row : matrix) 
    { 
      for (int col : row) 
      { 
        System.out.print(col + " "); 
      } // not particular about extra trailing space here 
      System.out.println(); 
    } 
  } 
  private static void paintBucketFill(int[][] colorMatrix, int row, int col, int colour)
  {
    int current = colorMatrix[row][col];
    
    colorMatrix[row][col] = colour;
    if(colorMatrix[row-1][col] == current)
      paintBucketFill(colorMatrix, row-1, col, colour);
    if(colorMatrix[row+1][col] == current)
      paintBucketFill(colorMatrix, row+1, col, colour);
    if(colorMatrix[row][col-1] == current)
      paintBucketFill(colorMatrix, row, col-1, colour);
    if(colorMatrix[row][col+1] == current)
      paintBucketFill(colorMatrix, row, col+1, colour);
  }
  
  public static void main(String[] args) 
  { 
    int[][] colorMatrix = { 
      {1,1,1,1,2,2,2,1}, 
      {1,1,1,0,0,0,0,2}, 
      {2,1,0,0,0,0,2,2}, 
      {1,0,0,0,0,0,2,2}, 
      {2,0,0,2,2,2,1,1}, 
      {2,0,0,2,2,0,0,0}, 
      {1,1,1,0,0,0,0,0}, 
      {0,0,0,0,0,0,0,2} }; 
    System.out.println("Before fill..."); 
    printMatrix(colorMatrix); 
    System.out.println(); 
    paintBucketFill(colorMatrix, 2, 3, 2); /* TODO : Implement that */ 
    System.out.println("After fill...");
    printMatrix(colorMatrix);
  }
}