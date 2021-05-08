import java.util.*;
import java.io.*;

public class agame {
	static int[][] dp = new int[105][105];
	static boolean[][] visited = new boolean[105][105];
	static int[] board = new int[105];

	static int solve(int A, int B) {
		if (A > B) {
			return 0;
		}
		if (!visited[A][B]) {
			visited[A][B] = !visited[A][B];
			dp[A][B] = Math.max(Math.min(solve(A + 1, B - 1), solve(A + 2, B)) + board[A],
					Math.min(solve(A + 1, B - 1), solve(A, B - 2)) + board[B]);
		}

		return dp[A][B];
	}

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int total = 0;
		for (int i = 0; i < n; i++) {
			board[i] = sc.nextInt();
			total += board[i];
		}
		int p1 = solve(0, n - 1);
		int p2 = total - p1;
		System.out.println(p1 + " " + p2);
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
