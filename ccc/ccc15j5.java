package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ccc15j5 {
	public static int counter;

	public static void calculate(int people, int pies, int min) {
		int range = pies / people;
		if (people == 2) {
			counter+= range -min + 1;
			return;
		}
		for (int i = min; i <= range; i++) {
			calculate(people - 1, pies - i, i);
		
		}
	}

	public static void main(String[] args) {
		FastReader fs = new FastReader();
		counter = 0;
		int n = fs.nextInt();
		int k = fs.nextInt();
		System.out.println(0/2);
		calculate(k, n, 1);
		System.out.println(counter);
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
