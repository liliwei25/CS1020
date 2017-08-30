/*
 * Name		: Li Liwei
 * Matric No.	: A0155991R
 */

import java.util.*;

public class Bombs 
{
    public static void main(String[] args) 
	{
		Scanner scn = new Scanner(System.in);

		int x = scn.nextInt();
		int y = scn.nextInt();

		int[][] grid = new int[x][y];
		for(int i = 0; i < x; i ++)
			for(int n = 0; n < y; n++)
				grid[i][n] = scn.nextInt();
		
		int num = scn.nextInt();
		int[] queries = new int[num];
		for(int i = 0; i < num; i ++)
			queries[i] = scn.nextInt();
		
		int[][] best = new int[2][3];
		int[] bestSize  = new int[4]; 

		for(int i = 0; i < num; i ++)
		{
			best = checkBombs(queries[i], grid, x, y);
			System.out.println(best[0][1] + " "+ best[0][2]);
    	}
		for(int i = 1; i < x+1 || i < y+1; i+=2)
		{
			best = checkBombs(i, grid, x, y);
			if(best[1][0] > bestSize[0])
			{
				bestSize[0] = best[1][0];
				bestSize[1] = best[1][1];
				bestSize[2] = best[1][2];
				bestSize[3] = i;
			}
		}
		System.out.println(bestSize[1] + " " + bestSize[2] + " " + bestSize[3]);
	}
	public static int[][] checkBombs(int size, int[][] grid, int x, int y)
	{
		int[][] best= new int[2][3];
		int bombs = 0;
		int score = 0;
		for(int i = 0; i<x; i++)
		{
			for(int n = 0; n < y; n++)
			{
				for(int k = i-(size/2); k <= i+(size/2); k++)
				{
					if(k < 0 || k >= x) continue;
					else
					{
						for(int j = n - size/2; j <= n+size/2; j++)
						{
							if(j < 0 || j >= y) continue;
							else
							{
								if(grid[k][j] == 1)
								{
									bombs++;
									score+=3;
								}
								else score--;
								//System.out.println(score);
							}
						}
					}
				}
				if(bombs > best[0][0])
				{
					best[0][0] = bombs;
					best[0][1] = i;
					best[0][2] = n;
				}
				if(score > best[1][0])
				{
					best[1][0] = score;
					best[1][1] = i;
					best[1][2] = n;
					//System.out.println(i + " " + n + " " + score);
				}
				//System.out.println(bombs + " " + score);
				bombs = 0;
				score = 0;
			}
		}

		return best;
	}
}
