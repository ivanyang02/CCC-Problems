package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ccc14s4 {
	public static class row implements Comparable<row> {
		int leftx;
		int rightx;
		int y;
		int tint;

		public row(int leftx, int rightx, int y, int tint) {
			this.leftx = leftx;
			this.rightx = rightx;
			this.y = y;
			this.tint = tint;
		}

		public int compareTo(row o) {
			return y - o.y;
		}
	}

	public static class column implements Comparable<column> {
		int x;
		int tint;

		public column(int x, int tint) {
			this.x = x;
			this.tint = tint;
		}

		public int compareTo(column o) {
			return x - o.x;
		}
	}

	public static void main(String[] args) throws IOException {
		FastReader br = new FastReader();
		int pieces = br.nextInt();
		int goaltint = br.nextInt();
		ArrayList<column> point = new ArrayList<column>();
		row[] rows = new row[pieces * 2];
		for (int i = 0; i < pieces; i++) {
			int x1 = br.nextInt();
			int y1 = br.nextInt();
			int x2 = br.nextInt();
			int y2 = br.nextInt();
			int tint = br.nextInt();
			rows[i * 2] = new row(x1, x2, y1, tint);
			rows[i * 2 + 1] = new row(x1, x2, y2, -tint);
		}

		Arrays.sort(rows, 0, pieces * 2);
		long area = 0;

		for (int i = 0; i < pieces * 2 - 1; i++) {
			point.add(new column(rows[i].leftx, rows[i].tint));
			point.add(new column(rows[i].rightx, -rows[i].tint));
			Collections.sort(point);
			int sum = 0;
			for (int j = 0; j < point.size() - 1; j++) {
				sum += point.get(j).tint;
				if (sum >= goaltint) {
					area += 1L * (point.get(j + 1).x - point.get(j).x) * (rows[i + 1].y - rows[i].y);
				}
			}
		}

		System.out.println(area);

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
