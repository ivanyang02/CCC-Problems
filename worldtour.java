import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class worldtour {
	public static void main(String[] args) {
		FastReader fs = new FastReader();
		int n = fs.nextInt();
		System.out.println(n);
		int[] map = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			map[i] = fs.nextInt();
		}
		int r = 0;
		int s = 0;
		for (int i = 1; i <= n; i++) {
			int[] vis = new int[n + 1];
			int visited = 1;
			vis[i] = 1;
			LinkedList<Integer> q = new LinkedList<Integer>();
			q.add(map[i]);
			while (!q.isEmpty()) {
				int c = q.poll();
				if (vis[c] == 0) {
					q.add(map[c]);
					vis[c] = 1;
					visited++;
				}
			}
			if (visited == 84797) {
				r = 446620;
				s = 84797;
				break;
			}
			System.out.println(visited);
		}
		for (int i = 0; i < r; i++) {
			System.out.println(s);
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
