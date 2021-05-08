import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class farmingsimulator {
	public static class hole implements Comparable<hole> {
		int i;
		double wait;
		int curtime;

		public hole(int i, double wait, int curtime) {
			this.i = i;
			this.wait = wait;
			this.curtime = curtime;
		}

		@Override
		public int compareTo(hole o) {
			if (this.i > o.i) {
				return 1;
			} else if (this.i < o.i) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	public static void main(String[] args) {
		FastReader fs = new FastReader();
		int n = fs.nextInt();
		int h = fs.nextInt();
		hole[] holes = new hole[n + 1];
		for (int i = 0; i < n; i++) {
			int pos = fs.nextInt();
			int wait = fs.nextInt();
			holes[i] = new hole(pos, wait, -1);
		}
		holes[n] = new hole(h, -1, -1);
		Arrays.sort(holes);
		int time = 0;
		time += holes[0].i;
		for (int i = 0; i < n; i++) {
			int largest = holes[i].i;
			for (int j = i; j < n; j++) {
				if (holes[i].wait / 2 >= holes[j].i) {
					largest = holes[j].i;
					holes[j].curtime = (int) holes[i].wait - (holes[i].i - holes[j].i);
				} else {
					break;
				}
			}
			time += holes[i].wait;
			if (i != n - 1) {
				time += holes[i + 1].i - holes[i].i;
			}
		}
		time += holes[n].i - holes[n - 1].i;

		System.out.println(time);
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
