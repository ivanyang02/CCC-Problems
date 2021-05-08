import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class thetriangle {
	public static void main(String[] args) {
		FastReader fs = new FastReader();
		int l = fs.nextInt();
		int[][] triangle = new int[l][l];
		int[][] step = new int[l][l];
		for (int i = 0; i < l; i++) {
			for (int j = 0; j <= i; j++) {
				triangle[i][j] = fs.nextInt();
			}
		}
		step[0][0] = triangle[0][0];
		int max = 0;
		for (int i = 1; i < l; i++) {
			for (int j = 0; j <= i; j++) {
				if (j > 0) {
					step[i][j] = Math.max(step[i - 1][j - 1], step[i - 1][j]) + triangle[i][j];
				} else {
					step[i][j] = step[i - 1][j] + triangle[i][j];
				}
				if (step[i][j] > max) {
					max = step[i][j];
				}
			}
		}
		System.out.println(max);
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
