import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class stones {
	static boolean[] dp = new boolean[1 << 17];
	static boolean[] visit = new boolean[1 << 17];
	static int[] elements;

	public static boolean solve(int k) {
		if (k < 0) {
			return true;
		}
		if (visit[k]) {
			return dp[k];
		}
		visit[k] = true;
		dp[k] = false;
		for (int i = 0; i < elements.length; i++) {
			if (!solve(k - elements[i])) {
				dp[k] = true;
			}
		}

		return dp[k];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		elements = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			elements[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solve(k) ? "First" : "Second");
	}
}
