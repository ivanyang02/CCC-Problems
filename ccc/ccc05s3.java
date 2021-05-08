package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ccc05s3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int numberofarrays = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int rows = Integer.parseInt(st.nextToken());
		int columns = Integer.parseInt(st.nextToken());
		int[][] basearray = new int[rows][columns];
		boolean impossible = false;
		if (rows == 0 || columns == 0) {
			impossible = true;
		}
		if (rows > 0 && columns > 0) {
			for (int i = 0; i < rows; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < columns; j++) {
					basearray[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < numberofarrays - 1; i++) {
				st = new StringTokenizer(br.readLine());
				rows = Integer.parseInt(st.nextToken());
				columns = Integer.parseInt(st.nextToken());
				if (rows == 0 || columns == 0) {
					impossible = true;
				}
				int[][] newarray = new int[rows][columns];
				for (int j = 0; j < rows; j++) {
					st = new StringTokenizer(br.readLine());
					for (int k = 0; k < columns; k++) {
						newarray[j][k] = Integer.parseInt(st.nextToken());
					}
				}
				int[][] array = new int[rows * basearray.length][columns * basearray[0].length];
				for (int j = 0; j < array.length; j++) {
					for (int k = 0; k < array[0].length; k++) {
						array[j][k] = basearray[j / rows][k / columns] * newarray[j % rows][k % columns];
					}
				}
				basearray = array;
			}
		}
		if (impossible == true) {
			return;
		}
		// for (int i = 0; i < basearray[0].length; i++) {
		// for (int j = 0; j < basearray.length; j++) {
		// System.out.print(basearray[i][j] + " ");
		// }
		// System.out.println("");
		// }
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int maxrow = Integer.MIN_VALUE;
		int minrow = Integer.MAX_VALUE;
		int maxcol = Integer.MIN_VALUE;
		int mincol = Integer.MAX_VALUE;
		for (int i = 0; i < basearray.length; i++) {
			int sum = 0;
			for (int j = 0; j < basearray[0].length; j++) {
				sum += basearray[i][j];
				if (basearray[i][j] > max) {
					max = basearray[i][j];
				}
				if (basearray[i][j] < min) {
					min = basearray[i][j];
				}
			}
			if (sum > maxrow) {
				maxrow = sum;
			}
			if (sum < minrow) {
				minrow = sum;
			}
		}
		for (int i = 0; i < basearray[0].length; i++) {
			int sum = 0;
			for (int j = 0; j < basearray.length; j++) {
				sum += basearray[j][i];
			}
			if (sum > maxcol) {
				maxcol = sum;
			}
			if (sum < mincol) {
				mincol = sum;
			}
		}
		System.out.println(max);
		System.out.println(min);
		System.out.println(maxrow);
		System.out.println(minrow);
		System.out.println(maxcol);
		System.out.println(mincol);
	}
}
