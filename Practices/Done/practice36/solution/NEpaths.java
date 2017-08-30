// Author: Aaron Tan

import java.util.*;

public class NEpaths {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter rows apart: ");
		int rows = sc.nextInt();
		System.out.print("Enter columns apart: ");
		int cols = sc.nextInt();

		String path = "";
		System.out.println("Number of paths = " + ne(rows, cols, path));
	}

	// To compute the number of NE paths as well as to display the paths
	public static int ne(int rows, int cols, String path) {
		if (rows == 0 && cols == 0) {
			printPath(path);
			return 1;
		}
		else {
			int pathNorth = 0;
			int pathEast = 0;
			if (rows > 0) 
				pathNorth = ne(rows-1, cols, path+"N");
			if (cols > 0) 
				pathEast = ne(rows, cols-1, path+"E");
			return pathNorth + pathEast;
		}
	}

	// To display a path
	public static void printPath(String path) {
		for (int i=0; i<path.length(); i++)
			System.out.print(path.charAt(i) + " ");
		System.out.println();
	}
}

