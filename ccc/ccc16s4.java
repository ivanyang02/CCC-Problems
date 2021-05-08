package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ccc16s4 {

	static int max = 0;

	public static void combine(LinkedList<Integer> riceballs) {
		for (int i = 0; i < riceballs.size() - 1; i++) {
			if (riceballs.get(i) == riceballs.get(i + 1)) {
				riceballs.set(i, riceballs.get(i) * 2);
				riceballs.remove(i + 1);
				combine(riceballs);
			} else if (i != riceballs.size() - 2 && riceballs.get(i) == riceballs.get(i + 2)) {
				riceballs.set(i, riceballs.get(i) * 2 + riceballs.get(i + 1));
				riceballs.remove(i + 1);
				riceballs.remove(i + 1);
				combine(riceballs);
			}
		}
		for (int i = 0; i < riceballs.size(); i++) {
			if (riceballs.get(i) > max) {
				max = riceballs.get(i);
			}
		}
	}

	public static void main(String[] args) {
		FastReader fs = new FastReader();
		int n = fs.nextInt();
		LinkedList<Integer> riceballs = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			int a = fs.nextInt();
			if (a > max) {
				max = a;
			}
			riceballs.add(a);
		}
		combine(riceballs);
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
