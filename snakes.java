import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class snakes {
	public static void main(String[] args) {
		//FastReader fs = new FastReader();
		FastReader fs = new FastReader(new FileInputStream("snakes.in"));
		PrintWriter pw = new PrintWriter("snakes.out");
		int n = fs.nextInt();
		int K = fs.nextInt() + 1;
		int[] a = new int[405];
		int[][] dp = new int[405][405];
		for (int i = 1; i <= n; i++) {
			a[i] = fs.nextInt();
		}
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], (1 << 30));
		}
		dp[0][0] = 0;
		for (int i = 0; i <= K; i++) {
			for (int j = 0; j < n; j++) {
				int sum = 0;
				int hi = 0;
				for (int k = j + 1; k <= n; k++) {
					sum += a[k];
					hi = Math.max(hi, a[k]);
					int cost = hi * (k - j) - sum;
					dp[i + 1][k] = Math.min(dp[i + 1][k], dp[i][j] + cost);
				}
			}
		}
		System.out.println(dp[K][n]);

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
