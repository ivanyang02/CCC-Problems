import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class claireelstein {
	static int n, m, path_sum[] = new int[100005], path_count[] = new int[100005];
	static int maxn = 1000000007;
	static ArrayList<Integer> adj[] = new ArrayList[100005];

	static void dfs(int N) {
		if (adj[N].size() == 0) {
			path_sum[N] = 0;
			path_count[N] = 1;
			return;
		}
		if (path_count[N] > 0) {
			return;
		}
		for (int i : adj[N]) {
			dfs(i);
			path_count[N] = (path_count[N] + path_count[i]) % maxn;
			path_sum[N] = (path_sum[N] + path_count[i]) % maxn;
			path_sum[N] = (path_sum[N] + path_sum[i]) % maxn;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] indegree = new int[100005];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			indegree[b]++;
		}
		long ans = 0;
		for (int l = 1; l <= n; l++) {
			if (indegree[l] == 0) {
				dfs(l);
				ans = (ans + path_sum[l]) % maxn;
			}
		}
		System.out.println(ans);
	}
}
