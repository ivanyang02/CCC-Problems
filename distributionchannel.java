import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class distributionchannel {
	public static class edge implements Comparable<edge> {
		int s;
		int e;
		int c;

		public edge(int s, int e, int c) {
			this.s = s;
			this.e = e;
			this.c = c;
		}

		@Override
		public int compareTo(edge o) {
			if (this.c > o.c) {
				return 1;
			}
			if (this.c < o.c) {
				return -1;
			}
			return 0;
		}
	}

	static int n;
	static ArrayList<Integer>[] map = new ArrayList[50005];
	static ArrayList<Integer>[] cost = new ArrayList[50005];

	static ArrayList<Integer>[] mst = new ArrayList[50005];

	static int[] mstset = new int[50005];

	public static void prim() {
		int msts = 0;
		mstset[1] = 1;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		PriorityQueue<edge> edges = new PriorityQueue<edge>();
		queue.add(1);
		while (!queue.isEmpty()) {
			if (msts == n - 2) {
				break;
			}
			int curnode = queue.poll();
			for (int i = 0; i < map[curnode].size(); i++) {
				int a = map[curnode].get(i);
				if (mstset[a] == 0) {
					queue.add(a);
					edges.add(new edge(curnode, a, cost[curnode].get(i)));
				}
			}
			if (!edges.isEmpty()) {
				edge curedge = edges.poll();
				while (mstset[curedge.e] == 1 && !edges.isEmpty()) {
					curedge = edges.poll();
				}
				if (mstset[curedge.e] == 1 && edges.isEmpty()) {
					break;
				}
				mstset[curedge.e] = 1;
				mst[curedge.s].add(curedge.e);
				mst[curedge.e].add(curedge.s);
			}
		}
		for (int i = 1; i < 10; i++) {
			if (mst[i].size() > 0) {
				System.out.println(i + " " + mst[i].get(0));
			}
		}
	}

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		n = sc.nextInt();
		int m = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			map[i] = new ArrayList<Integer>();
			cost[i] = new ArrayList<Integer>();
			mst[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
			map[a].add(b);
			cost[a].add(c);
			map[b].add(a);
			cost[b].add(c);
		}
		prim();
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
