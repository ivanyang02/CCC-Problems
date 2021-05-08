import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class topbilling {
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

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int r = sc.nextInt();
		int c = sc.nextInt();
		if (c == 2) {
			System.out.println("SE");
			for (int i = 0; i < r - 1; i++) {
				System.out.println("..");
			}
			return;
		}
		for (int j = 0; j < c; j++) {
			System.out.print(".");
		}
		System.out.println("");
		for (int i = 0; i < c - 2; i++) {
			for (int j = 0; j < c - i - 2; j++) {
				System.out.print(".");
			}
			for (int j = 0; j < i + 1; j++) {
				System.out.print("#");
			}
			if (i != c - 3) {
				System.out.println(".");
			} else {
				System.out.println("E");
			}
		}
		System.out.print("S");
		for (int j = 0; j < c - 1; j++) {
			System.out.print(".");
		}
		System.out.println("");
		for (int i = 0; i < r - c; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(".");
			}
			System.out.println("");
		}
	}
}
