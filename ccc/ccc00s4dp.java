package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ccc00s4dp {
	public static void main(String[] args) {
		FastReader fs = new FastReader();
		int x = fs.nextInt() + 1;
		int n = fs.nextInt();
		int[] denominations = new int[n];
		int[] mins = new int[x];
		for (int i = 0; i < n; i++) {
			denominations[i] = fs.nextInt();
		}
		Arrays.fill(mins, 1 << 30);
		mins[0] = 0;
		for (int i = 1; i < x; i++) {
			int min = 1 << 30;
			for (int j = 0; j < n; j++) {
				if (i - denominations[j] >= 0 && min > mins[i - denominations[j]] + 1) {
					min = mins[i - denominations[j]] + 1;
				}
			}
			mins[i] = min;
		}
		System.out.println(mins[x-1]);
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
