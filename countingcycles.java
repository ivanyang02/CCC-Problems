import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class countingcycles {
	static int map[][] = new int[11][11];
	static int ans = 0;
	static int dimensions = 0;
	static boolean used[] = new boolean[11];

	static void dfs(int node, int min) {
		// find all the cycles that has the minimum node min
		if (node > min)
			return;
		if (used[node]) {
			if (node == min)
				ans++;
			return;
		}
		used[node] = true;
		for (int i = 0; i < dimensions; i++) {
			if (map[node][i] == 1) {
				dfs(i, min);
			}
		}
		used[node] = false;
	}

	public static void main(String[] args) {
		FastReader in = new FastReader();
		dimensions = in.nextInt();
		for (int i = 0; i < dimensions; i++) {
			for (int j = 0; j < dimensions; j++) {
				map[i][j] = in.nextInt();
			}
		}
		for (int i = 0; i < dimensions; i++) {
			dfs(i, i);
		}
		System.out.println(ans);
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
