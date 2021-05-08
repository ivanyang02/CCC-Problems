import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class sawmillschemedfs {
	static int n, m;
	static ArrayList<Integer> adj[] = new ArrayList[1000005];
	static double p[] = new double[1000005];

	static void dfs(int N) {
		for (int i : adj[N]) {
			p[i] += p[N] / adj[N].size();
			dfs(i);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
		}
		p[1] = 1;
		dfs(1);
		for (int i = 1; i <= n; i++) {
			if (adj[i].size() == 0) {
				System.out.println(p[i]);
			}
		}
	}
}
