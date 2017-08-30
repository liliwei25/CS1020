/*
 * Name		: Li Liwei
 * Matric No.	: A0155991R
 */

import java.util.*;

public class Bombs 
{

	public static void main(String[] args) 
	{
		Scanner myScanner = new Scanner(System.in);

		int gridX = myScanner.nextInt(); //get number of rows
		int gridY = myScanner.nextInt(); // get number of columns

		int[][] grid = new int[gridX][gridY]; // array to store grid
		int[][] max = new int[2][3]; // array to store score, x-coordinates and y-coordinates of max score
		int[] bestMax = new int[4];//array to store values for best bomb with minimum size
		bestMax[3] = gridX + gridY;

		for(int i = 0; i < gridX; i++) // get grid values
		{
			for(int n = 0; n < gridY; n++)
				grid[i][n] = myScanner.nextInt();
		}

		int numOfQ = myScanner.nextInt(); //get number of type-1 queries
		int queries[] = new int[numOfQ]; //array to store all type-1 queries

		for(int i = 0; i < numOfQ; i++) //get all type-1 queries
			queries[i] = myScanner.nextInt();

		for(int m = 0; m < numOfQ; m++) //go through all type-1 queries
		{
			max = sophisticatedProgram(grid, gridX, gridY, queries[m]);
			System.out.printf("%d %d\n", max[1][1], max[1][2]); //x and y coordinates of best bomb deployment
		}

		for(int m = 1; m <= gridX+1 || m <= gridY+1; m+=2) //go through all type-2 queries
		{
			max = sophisticatedProgram(grid, gridX, gridY, m);
			//System.out.printf("%d %d %d %d\n", m, max[0][0], max[0][1], max[0][2]);
			if(max[0][0] > bestMax[0])
			{
				bestMax[0] = max[0][0];
				bestMax[1] = max[0][1];
				bestMax[2] = max[0][2];
				bestMax[3] = m;
			}
		}
		System.out.println(bestMax[1] + " " + bestMax[2] + " " + bestMax[3]);
	}

	public static int[][] sophisticatedProgram(int[][] grid, int gridX, int gridY, int bombSize) // sophisticated program to go through all positions in grid with a specific bomb size
	{
		int score = 0, startX = 0, startY = 0, count = 0;
		int[][] max = new int[2][3];

		for(int i = 0; i < gridX; i++) //go through every grid
		{
			for(int n = 0; n < gridY; n++)
			{
				for(int k = i -(bombSize-1)/2; k <= i + (bombSize-1)/2 && k < gridX; k++) //calculate score
				{
					if(k < 0)continue;
					for(int j = n - (bombSize-1)/2; j <= n + (bombSize-1)/2 && j < gridY; j++)
					{
						if(j < 0) continue;
						if(grid[k][j] == 1) 
						{
							count++;
							score+=3;
						}
						else score--;
					}
				}
				if(score > max[0][0]) //update max values for type-2
				{
					max[0][0] = score;
					max[0][1] = i;
					max[0][2] = n;
				}
				if(count > max[1][0])// update max values for type-1
				{
					max[1][0] = count;
					max[1][1] = i;
					max[1][2] = n;
				}
				count = 0;
				score = 0;
			}
		}
		return max;
	}
}
