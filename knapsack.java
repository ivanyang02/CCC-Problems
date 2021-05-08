import java.util.LinkedList;
import java.util.Scanner;

public class knapsack {
	static Scanner sc = new Scanner(System.in);

	public static int calculate(int[] a, int[] b, int weight, int n) {
		int[][] k = new int[n+1][weight+1];
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < weight+1; j++) {
				if (i == 0 || j == 0) {
					k[i][j] = 0;
				} else if (b[i - 1] <= j) {
					k[i][j] = max(a[i - 1] + k[i - 1][j - b[i - 1]], k[i - 1][j]);
				} else {
					k[i][j] = k[i - 1][j];
				}
			}
		}
		return k[n][weight];
	}

	public static int max(int a, int b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}

	public static void main(String[] args) {
		int[] a = { 4, 2, 3, 4 };
		int[] b = { 2, 4, 1, 3 };
		int weight = 6;
		int n = a.length;
		System.out.println(calculate(a, b, weight, n));
	}
}