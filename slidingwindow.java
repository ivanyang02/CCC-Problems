import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class slidingwindow {
	public static void main(String[] args) {
		FastReader fs = new FastReader();
		int n = fs.nextInt();
		int k = fs.nextInt();
		int budget = fs.nextInt();
		boolean[] range = new boolean[k];
		for (int i = 0; i < n; i++) {
			range[fs.nextInt()] = true;
		}
		int max = 0;
		int curr = 0;
		int curl = -budget;
		int cur = 0;
		for (int i = 0; i < 1 << 30; i++) {
			if (range[curr] == true) {
				cur++;
			}
			if (curl - 1 >= 0) {
				if (range[curl - 1] == true) {
					cur--;
				}
			}
			max = Math.max(max, cur);
			curr++;
			curl++;
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
