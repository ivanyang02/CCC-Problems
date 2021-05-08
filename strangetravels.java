import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class strangetravels {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int n = sc.nextInt(), m = sc.nextInt();
		ArrayList<Integer>[] portals = new ArrayList[100005];
		ArrayList<Integer>[] returntrip = new ArrayList[100005];
		for (int i = 1; i <= n; i++) {
			portals[i] = new ArrayList<Integer>();
			returntrip[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt(), b = sc.nextInt();
			portals[a].add(b);
			returntrip[b].add(a);
		}
		int k = sc.nextInt();
		LinkedList<Integer> artifacts = new LinkedList<Integer>();
		for (int i = 0; i < k; i++) {
			artifacts.add(sc.nextInt());
		}
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int[] step = new int[100005];
		int[] step1 = new int[100005];

		int dist = 0;

		Arrays.fill(step, 1 << 30);
		step[1] = 0;
		queue.add(1);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < portals[cur].size(); i++) {
				if (step[portals[cur].get(i)] > step[cur] + 1) {
					step[portals[cur].get(i)] = step[cur] + 1;
					queue.add(portals[cur].get(i));
				}
			}
		}

		Arrays.fill(step1, 1 << 30);
		step1[1] = 0;
		queue.add(1);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < returntrip[cur].size(); i++) {
				if (step1[returntrip[cur].get(i)] > step1[cur] + 1) {
					step1[returntrip[cur].get(i)] = step1[cur] + 1;
					queue.add(returntrip[cur].get(i));
				}
			}
		}
		for (int i = 0; i < artifacts.size(); i++) {
			if (step[artifacts.get(i)] == 1 << 30) {
				System.out.println(-1);
				return;
			}
			dist += step[artifacts.get(i)];
			if (step1[artifacts.get(i)] == 1 << 30) {
				System.out.println(-1);
				return;
			}
			dist += step1[artifacts.get(i)];
		}
		System.out.println(dist);
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
