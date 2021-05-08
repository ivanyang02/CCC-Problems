import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class reachfortop {
	public static void main(String[] args) {
		FastReader fs = new FastReader();
		int h = fs.nextInt();
		int jump = fs.nextInt();
		int n = fs.nextInt();
		// System.out.println(h + " " + jump + " " + n);
		int[] rope = new int[h + jump];
		Arrays.fill(rope, 1 << 30);
		rope[0] = 0;
		int[] itch = new int[h + jump + 1];
		for (int i = 0; i < n; i++) {
			int a = fs.nextInt();
			int b = fs.nextInt();
			// System.out.println(a + " " + b);
			for (int j = a; j <= b; j++) {
				itch[j] = 1;
			}
		}
		int max = 0;
		int tempmax = 0;
		int tempdist = 0;
		int dist = 0;
		for (int i = 0; i < h; i++) {
			if (itch[i] == 0 && i < max) {
				rope[i] = Math.min(dist + 1, rope[i]);
			}
			if (itch[i] == 0 && itch[i + jump] == 0 && rope[i] != 1 << 30) {
				rope[i + jump] = Math.min(rope[i + jump], rope[i] + 1);
				tempmax = i + jump;
				tempdist = rope[i + jump];
			}
			if (i == max) {
				max = tempmax;
				dist = tempdist;
			}
		}
		int min = 1 << 30;
		for (int i = h; i < h + jump; i++) {
			min = Math.min(min, rope[i]);
		}
		if (min == 1 << 30) {
			System.out.println(-1);
		} else {
			System.out.println(min);
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
