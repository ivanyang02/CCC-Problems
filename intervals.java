import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class intervals {
	public static class point implements Comparable<point> {
		int type;
		int location;
		int order;

		public point(int _type, int _location, int _order) {
			this.type = _type;
			this.location = _location;
			this.order = _order;
		}

		@Override
		public int compareTo(point o){
			if (this.location > o.location) {
				return 1;
			}
			if (this.location < o.location) {
				return -1;
			}
			if (this.type < o.type) {
				return -1;
			}
			if (this.type > o.type) {
				return 1;
			}
			return this.order < o.order?-1:1;
		}
	}

	public static void main(String[] args) {
		FastReader fs = new FastReader();
		int n = fs.nextInt();
		int q = fs.nextInt();
		// System.out.println(n + " " + q);
		point[] points = new point[300005];
		int[] ans = new int[100005];
		int counter = 0;
		for (int i = 0; i < n; i++) {
			int a = fs.nextInt();
			int b = fs.nextInt();
			//int a=0, b=0;
			points[counter] = new point(0, a, -1);
			counter++;
			points[counter] = new point(2, b, -1);
			counter++;
			// System.out.println(a + " " + b);
		}
		//System.out.println(counter);
		for (int i = 0; i < q; i++) {
			int a = fs.nextInt();
			//int a=0;
			points[counter] = new point(1, a, i);
			counter++;
			// System.out.println(a);
		}
		//System.out.println(counter);
		counter = 0;
		Arrays.sort(points, 0, 2 * n + q);
		//if (true) {
			//return;
		//}
		for (int i = 0; i < n * 2 + q; i++) {
			point a = points[i];
			if (a.type == 0) {
				counter++;
			}
			if (a.type == 2) {
				counter--;
			}
			if (a.type == 1) {
				ans[a.order] = counter;
			}
		}
		for (int i = 0; i < q; i++) {
			System.out.println(ans[i]);
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
