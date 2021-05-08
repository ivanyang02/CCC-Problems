package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ccc15s4 {
	public static class edge implements Comparable<edge> {
		int s;
		int e;
		int c;
		int h;

		public edge(int s, int e, int c, int h) {
			this.s = s;
			this.e = e;
			this.c = c;
			this.h = h;
		}

		public int compareTo(edge o) {
			if (this.c > o.c) {
				return 1;
			}
			if (this.c < o.c) {
				return -1;
			}
			if(this.h > o.h) {
			//	return 1;
			}
			if(this.h < o.h) {
			//	return -1;
			}
			return 0;
		}
	}

	static int min;
	static int hull;
	static int islands;
	static int routes;
	static ArrayList<edge>[] edges;

	public static void dfs(int s, int e, int curh, int curt, int[] step) {
		step[s] = 1;
		if (s == e) {
			// if (curt < min) {
			// min = curt;
			// return;
			// }
			System.out.println(curt);
			System.exit(0);
		}
		for (int i = 0; i < edges[s].size(); i++) {
			if (edges[s].get(i).h < curh && step[edges[s].get(i).e] != 1) {
				step[edges[s].get(i).e] = 1;
				dfs(edges[s].get(i).e, e, curh - edges[s].get(i).h, curt + edges[s].get(i).c, step);
				step[edges[s].get(i).e] = 0;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		hull = Integer.parseInt(st.nextToken());
		islands = Integer.parseInt(st.nextToken());
		routes = Integer.parseInt(st.nextToken());
		edges = new ArrayList[2005];
		min = 1 << 30;
		for (int i = 1; i <= islands; i++) {
			edges[i] = new ArrayList<edge>();
		}
		for (int i = 1; i <= routes; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			edges[s].add(new edge(s, e, c, h));
			edges[e].add(new edge(e, s, c, h));
		}
		for (int i = 1; i <= islands; i++) {
			Collections.sort(edges[i]);
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int curhull = hull;
		int[] step = new int[islands + 1];
		step[start] = 0;
		dfs(start, end, curhull, 0, step);
		System.out.println(-1);
		// if (min == 1 << 30) {
		// System.out.println(-1);
		// } else {
		// System.out.println(min);
		// }
	}
}
