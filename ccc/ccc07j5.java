package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ccc07j5 {
	public static class motel implements Comparable<motel> {
		int dist;
		long ways;

		public motel(int dist) {
			this.dist = dist;
			this.ways = 0;
		}

		public int compareTo(motel o) {
			if (this.dist > o.dist) {
				return 1;
			}
			if (this.dist < o.dist) {
				return -1;
			}
			return 0;
		}
	}

	public static void main(String[] args) {
		FastReader fs = new FastReader();
		int min = fs.nextInt();
		int max = fs.nextInt();
		int extra = fs.nextInt();
		motel[] motels = new motel[14 + extra];
		motels[0] = new motel(0);
		motels[1] = new motel(990);
		motels[2] = new motel(1010);
		motels[3] = new motel(1970);
		motels[4] = new motel(2030);
		motels[5] = new motel(2940);
		motels[6] = new motel(3060);
		motels[7] = new motel(3930);
		motels[8] = new motel(4060);
		motels[9] = new motel(4970);
		motels[10] = new motel(5030);
		motels[11] = new motel(5990);
		motels[12] = new motel(6010);
		motels[13] = new motel(7000);
		for (int i = 0; i < extra; i++) {
			motels[14 + i] = new motel(fs.nextInt());
		}
		Arrays.sort(motels);
		motels[0].ways = 1;

		for (int i = 0; i < 14 + extra; i++) {
			for (int j = i + 1; j < 14 + extra; j++) {
				int distance = motels[j].dist - motels[i].dist;
				if (distance >= min && distance <= max) {
					motels[j].ways += motels[i].ways;
				}
			}
		}
		System.out.println(motels[13 + extra].ways);
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
