import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class errands {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken()) - 1;
		ArrayList<Integer>[] map = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			map[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			map[u].add(v);
			map[v].add(u);
		}
		int[] step = new int[n];
		Arrays.fill(step, Integer.MAX_VALUE);
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			step[c] = 0;
			queue.add(c);
			while (!queue.isEmpty()) {
				int curv = queue.poll();
				for (int j : map[curv]) {
					if (step[j] > step[curv] + 1) {
						queue.add(j);
						step[j] = step[curv] + 1;
					}
				}
			}
			if (step[a] == Integer.MAX_VALUE || step[b] == Integer.MAX_VALUE) {
				System.out.println("This is a scam!");
			} else {
				System.out.println(step[a] + step[b]);
			}
		}
	}
}
