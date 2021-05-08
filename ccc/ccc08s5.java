package ccc;

import java.util.*;

public class ccc08s5 {

	static boolean[][][][] dp = new boolean[31][31][31][31], visit = new boolean[31][31][31][31];

	static boolean solve(int A, int B, int C, int D) {
		// if the last move is illegal, you win
		if (A < 0 || B < 0 || C < 0 || D < 0)
			return true;
		// if your state is visited, return your previous value
		if (visit[A][B][C][D])
			return dp[A][B][C][D];
		visit[A][B][C][D] = true;

		// set dp to true if any of the possible next values is false
		dp[A][B][C][D] = (!solve(A - 2, B - 1, C, D - 2) || !solve(A - 1, B - 1, C - 1, D - 1)
				|| !solve(A, B, C - 2, D - 1) || !solve(A, B - 3, C, D) || !solve(A - 1, B, C, D - 1));
		return dp[A][B][C][D];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
			System.out.println(solve(a, b, c, d) ? "Patrick" : "Roland");
		}
	}
}