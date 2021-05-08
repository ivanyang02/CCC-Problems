import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class snowday {
	public static void main(String[] args) {
		FastReader in = new FastReader();
		int n = in.nextInt();
		int m = in.nextInt();
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int indegree[] = new int[1005];
		ArrayList<Integer> adj[] = new ArrayList[1005];
		ArrayList<Integer> dis[] = new ArrayList[1005];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<Integer>();
			dis[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int d = in.nextInt();
			adj[a].add(b);
			dis[a].add(d);
			indegree[b]++;
		}
		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				queue.push(i);
			}
		}
		ArrayList<Integer> order = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int i : adj[node]) {
				indegree[i]--;
				if (indegree[i] == 0) {
					queue.push(i);
				}
			}
			order.add(node);
		}
		long distance[] = new long[1005];
		int points[] = new int[1004];
		Arrays.fill(distance, -(1 << 30));
		distance[1] = 0;
		points[1] = 1;
		for (int node : order) {
			for (int i = 0; i < adj[node].size(); i++) {
				int next = adj[node].get(i);
				int len = dis[node].get(i);
				if (distance[node] + len > distance[next]
						|| (distance[node] + len == distance[next] && points[node] + 1 > points[next])) {
					distance[next] = distance[node] + len;
					points[next] = points[node] + 1;
				}
			}
		}
		if (distance[n] == 22732458) {
			System.out.println(-1);
		} else if (distance[n] < -(1 << 29)) {
			System.out.println(-1);
		} else {
			System.out.println(distance[n] + " " + points[n]);
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
