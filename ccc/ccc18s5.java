package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ccc18s5 {
	public static class edge implements Comparable<edge> {
		int x;
		int y;
		int cost;
		int type;

		public edge(int x, int y, int cost, int type) {
			this.x = x;
			this.y = y;
			this.cost = cost;
			this.type = type;
		}

		public int compareTo(edge o) {
			return cost - o.cost;
		}
	}

	static int[] parentrow = new int[100005];
	static int[] parentcol = new int[100005];
	static int[] sizerow = new int[100005];
	static int[] sizecol = new int[100005];

	static int getRootRow(int x) {
		while (x != parentrow[x]) {
			x = parentrow[x];
		}
		return x;
	}

	static int getRootCol(int x) {
		while (x != parentcol[x]) {
			x = parentcol[x];
		}
		return x;
	}

	static boolean mergeRow(int x, int y) {
		x = getRootRow(x);
		y = getRootRow(y);
		if (x == y) {
			return false;
		}
		if (sizerow[x] < sizerow[y]) {
			return mergeRow(y, x);
		}
		parentrow[y] = x;
		sizerow[x] += sizerow[y];
		return true;
	}

	static boolean mergeCol(int x, int y) {
		x = getRootCol(x);
		y = getRootCol(y);
		if (x == y) {
			return false;
		}
		if (sizecol[x] < sizecol[y]) {
			return mergeCol(y, x);
		}
		parentcol[y] = x;
		sizecol[x] += sizecol[y];
		return true;
	}

	public static void main(String[] args) {
		FastReader br = new FastReader();
		int n = br.nextInt();
		int m = br.nextInt();
		int p = br.nextInt();
		int q = br.nextInt();
		edge[] edgelist = new edge[200005];
		long originalcost = 0;
		for (int i = 1; i <= n; i++) {
			parentrow[i] = i;
			sizerow[i] = 1;
		}
		for (int i = 1; i <= m; i++) {
			parentcol[i] = i;
			sizecol[i] = 1;
		}

		for (int i = 0; i < p; i++) {
			edgelist[i] = new edge(br.nextInt(), br.nextInt(), br.nextInt(), 0);
			originalcost += 1L * edgelist[i].cost * n;

		}
		for (int i = 0; i < q; i++) {
			edgelist[p + i] = new edge(br.nextInt(), br.nextInt(), br.nextInt(), 1);
			originalcost += 1L * edgelist[p + i].cost * m;
		}
		Arrays.sort(edgelist, 0, p + q);
		int rowGroups = n;
		int colGroups = m;
		long ans = 0;
		for (int i = 0; i < p + q; i++) {
			int x = edgelist[i].x;
			int y = edgelist[i].y;
			int cost = edgelist[i].cost;
			int type = edgelist[i].type;
			if (type == 0) {
				if (mergeCol(x, y)) {
					ans += 1L * cost * rowGroups;
					colGroups--;
				}
			} else {
				if (mergeRow(x, y)) {
					ans += 1L * cost * colGroups;
					rowGroups--;
				}
			}
		}
		System.out.println(originalcost - ans);
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
