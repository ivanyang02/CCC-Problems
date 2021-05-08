import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class eyesofvoid {
	public static void main(String[] args) {
		FastReader fs = new FastReader();
		int n = fs.nextInt();
		int c = fs.nextInt();
		int[] a = new int[2000005];
		for (int i = 0; i < n; i++) {
			int d = fs.nextInt();
			int x = fs.nextInt();
			int y = fs.nextInt();
			a[x * x + y * y] += d;
		}
		int max = 0;
		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			temp += a[i];
			max = Math.max(max, temp - c * i);
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
