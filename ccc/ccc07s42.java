package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ccc07s42 {
	public static void main(String[] args) {
		FastReader fs = new FastReader();
		int n = fs.nextInt();
		int a = -1;
		int b = -1;
		ArrayList<Integer>[] map = new ArrayList[n + 1];
		int[] paths = new int[n + 1];
		paths[1] = 1;
		for (int i = 0; i < n + 1; i++) {
			map[i] = new ArrayList<Integer>();
		}
		while (a != 0 && b != 0) {
			a = fs.nextInt();
			b = fs.nextInt();
			map[a].add(b);
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 0; j < map[i].size(); j++) {
				paths[map[i].get(j)] += paths[i];
			}
		}
		System.out.println(paths[n]);
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
