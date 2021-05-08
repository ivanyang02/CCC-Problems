package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ccc19s4 {
	public static void main(String[] args) {
		FastReader fs = new FastReader();
		int n = fs.nextInt();
		int k = fs.nextInt();
		int[] cities = new int[n];
		for (int i = 0; i < n; i++) {
			cities[i] = fs.nextInt();
		}
		int min = n - k;
		int largest = 0;
		int lar = 0;
		int lar2 = 0;
		for (int i = 0; i < min; i++) {
			lar = Math.max(lar, cities[i]);
			lar2 = Math.max(lar2, cities[n - 1 - i]);
		}
		for (int i = min; i < min + Math.abs(min - k); i++) {
			int diff1 = lar - cities[i];
			int diff2 = lar2 - cities[i];
			if (diff1 < 0 && diff2 > 0) {
				lar = cities[i];
			} else if (diff1 > 0 && diff2 < 0) {
				lar2 = cities[i];
			} else if (diff1 < 0 && diff2 < 0) {
				if (diff1 < diff2) {
					lar = cities[i];
				} else {
					lar2 = cities[i];
				}
			}
		}
		largest = Math.max(largest, lar + lar2);
		System.out.println(largest);
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
