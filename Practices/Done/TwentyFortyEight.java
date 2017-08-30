/*
 * Name		: Li Liwei
 * Matric No.		:	A0155991R
 */

import java.util.*;

public class TwentyFortyEight 
{

	public static void main(String[] args) 
	{
		Scanner myScanner = new Scanner(System.in);

		int[][] grid = new int[4][4];

		for(int i = 0; i < 4; i++)
			for(int n = 0; n < 4; n++)
				grid[i][n] = myScanner.nextInt();

		int move = myScanner.nextInt();

		if(move == 0) grid = moveLeft(grid);
		else if(move == 1) grid = moveUp(grid);
		else if(move == 2) grid = moveRight(grid);
		else grid = moveDown(grid);

		for(int i = 0; i < 4; i++)
			System.out.printf("%d %d %d %d\n", grid[i][0], grid[i][1], grid[i][2], grid[i][3]);
	}

	public static int[][] moveLeft(int[][] grid)
	{
		boolean flag = false;
		int combines = 0;

		for(int i = 0; i < 4; i ++)
		{
			for(int j = 1; j < 4; j++)
			{
				for(int k = j; k > combines; k--)
				{
					if(grid[i][k] == 0) continue;
					if(grid[i][k-1] == 0)
					{
						grid[i][k-1] = grid[i][k];
						grid[i][k] = 0;
					}
					else if(grid[i][k] == grid[i][k-1] && flag == false)
					{
						grid[i][k-1] += grid[i][k];
						grid[i][k] = 0;
						flag = true;
						combines++;
					}
				}
				flag = false;
			}
			combines = 0;
		}
		return grid;
	}
	public static int[][] moveUp(int[][] grid)
	{
		boolean flag = false;
		int combines = 0;

		for(int j = 0; j < 4; j++)
		{
			for(int i = 1; i < 4; i++)
			{
				for(int k = i; k > combines; k--)
				{
					if(grid[k][j] == 0) continue;
					if(grid[k-1][j] == 0)
					{
						grid[k-1][j] = grid[k][j];
						grid[k][j] = 0;
					}
					else if(grid[k-1][j] == grid[k][j] && flag == false)
					{
						grid[k-1][j] += grid[k][j];
						grid[k][j] = 0;
						flag = true;
						combines++;
					}
				}
				flag = false;
			}
			combines = 0;
		}
		return grid;
	}
	public static int[][] moveRight(int[][] grid)
	{
		boolean flag = false;
		int combines = 0;

		for(int i = 2; i >= 0; i--)
		{
			for(int n = 0; n < 4; n++)
			{
				for(int j = i; j < 3-combines; j++)
				{
					if(grid[n][j] == 0) continue;
					if(grid[n][j+1] == 0)
					{
						grid[n][j+1] = grid[n][j];
						grid[n][j] = 0;
					}
					else if(grid[n][j+1] == grid[n][j] && flag == false)
					{
						grid[n][j+1] += grid[n][j];
						grid[n][j] = 0;
						flag = true;
						combines++;
					}
				}
				flag = false;
			}
			combines = 0;
		}
		return grid;
	}
	public static int[][] moveDown(int[][] grid)
	{
		boolean flag = false;
		int combines = 0;

		for(int j = 0; j < 4; j++)
		{
			for(int i = 2; i >=0; i--)
			{
				for(int k = i; k < 3-combines; k++)
				{
					if(grid[k][j] == 0) continue;
					if(grid[k+1][j] == 0)
					{
						grid[k+1][j] = grid[k][j];
						grid[k][j] = 0;
					}
					else if(grid[k+1][j] == grid[k][j] && flag == false)
					{
						grid[k+1][j] += grid[k][j];
						grid[k][j] = 0;
						flag = true;
						combines++;
					}
				}
				flag = false;
			}
			combines = 0;
		}
		return grid;
	}
}
