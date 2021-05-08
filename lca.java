import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class lca {

	static int n, d;
	static ArrayList<Integer>[] graph;
	static int par[], dep[];
	static int tbl[][];

	static void preprocessing() {
		LinkedList<Integer> q = new LinkedList<>();
		q.push(1);
		while (!q.isEmpty()) {
			int cur = q.pop();
			System.out.println();
			for (int i : graph[cur]) {
				if (i != par[cur]) {
					q.push(i);
					dep[i] = dep[cur] + 1;
					par[i] = cur;
				}
			}
		}
	}

	static void build() {
		d = 31 - Integer.numberOfLeadingZeros(n);
		tbl = new int[n + 1][d + 1];
		for (int i = 1; i <= n; i++) {
			tbl[i][0] = par[i];
		}
		for (int i = 0; i <= d; i++) {
			for (int j = 1; j <= n; j++) {
				tbl[j][i] = tbl[tbl[j][i - 1]][i - 1];
			}
		}
	}

	static int lca(int u, int v) {
		if (dep[u] < dep[v]) {
			int temp = u;
			u = v;
			v = temp;
		}
		while (dep[u] > dep[v]) {
			u = par[u];
		}
		while (u != v) {
			u = par[u];
			v = par[v];
		}
		return u;
	}

	static int binlft(int u, int v) {
		if (dep[u] < dep[v]) {
			int temp = u;
			u = v;
			v = temp;
		}
		for (int i = d; i >= 0; i--) {
			if (dep[tbl[u][d]] >= dep[v]) {
				u = tbl[u][d];
			}
		}
		if (u == v) {
			return u;
		}
		for (int i = d; i >= 0; i--) {
			if (tbl[u][d] != tbl[v][d]) {
				u = tbl[u][d];
				v = tbl[v][d];
			}
		}
		// because both nodes are one depth below the lca return the parent of u or v.
		return par[u];
	}

	public static void main(String[] args) {
		FastReader br = new FastReader();
		n = br.nextInt();
		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i < n; i++) {
			int a = br.nextInt();
			int b = br.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}
		dep = new int[n + 1];
		par = new int[n + 1];
		preprocessing();
		int q = br.nextInt();
		while (q-- > 0) {
			int u = br.nextInt();
			int v = br.nextInt();
			System.out.println(lca(u, v));
		}
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
