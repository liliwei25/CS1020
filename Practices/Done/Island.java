/*
 Name: Li Liwei
 Matric No.: A0155991R
 */

import java.util.*;

public class Island 
{
    public static void main(String[] args)
	{
		Scanner myScanner = new Scanner(System.in);

    	int gridX = myScanner.nextInt(); //get number of rows
		int gridY = myScanner.nextInt(); //get number of columns
		int tickets = 0; //keep track of tickets needed

		int[][] grid = new int[gridX][gridY]; //grid for map

		for(int i = 0; i < gridX; i++) //get value of map
		{
			for(int n = 0; n < gridY; n++)
				grid[i][n] = myScanner.nextInt();
		}

		for(int i = 0; i < gridX; i++) //go through every map position
		{
			for(int n = 0; n < gridY; n++)
			{
				if(grid[i][n] == 1) //if land is found
					if(!checkSurrounding(grid, i, n, gridX, gridY)) tickets++; //new island found
			}
		}

		System.out.println(tickets);
    }

	public static boolean checkSurrounding(int[][] grid, int i, int n, int gridX, int gridY) //checks surrounding for land
	{
		if(i < gridX-1) //same island to the bottom
			if(grid[i+1][n] == 1) return true;
		if(n < gridY-1) //same island to the right
			if(grid[i][n+1] == 1) return true;
		return false; //couldnt find land from the same island
						//PS. left and top not checked as the land belongs to the same island
	}
}
