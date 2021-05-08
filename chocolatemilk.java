import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class chocolatemilk {
	static int n, k, dp[][] = new int[405][805];
	static int[] c = new int[405], f = new int[405], p = new int[405];
	static ArrayList<Integer> adj[] = new ArrayList[405];

	static void dfs(int N) {
		dp[N][0] = p[N];
		for (int c : adj[N]) {
			dfs(c);
			int copy[] = new int[405];
			for (int j = 0; j <= k; j++) {
				for (int l = 0; l <= k; l++) {
					copy[j + l] = Math.max(copy[j + l], dp[N][j] + Math.min(dp[c][l], f[c]));
					copy[j + l + 1] = Math.max(copy[j + l + 1], dp[N][j] + dp[c][l]);
				}
			}
			dp[N] = copy;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 2; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			p[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			f[i] = Integer.parseInt(st.nextToken());
			adj[c[i]].add(i);
		}
		dfs(1);
		int ans = 0;
		for (int l = 0; l <= k; ++l) {
			ans = Math.max(ans, dp[1][l]);
		}
		System.out.println(ans);
	}
}
