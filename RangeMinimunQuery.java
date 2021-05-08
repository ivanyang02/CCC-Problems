import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RangeMinimunQuery {
	static int[] min = new int[400000];

	// stores where each segment begins and ends
	static int[] left = new int[400000], right = new int[400000];
	static int[] data = new int[100000];

	static void push_up(int segment) {
		min[segment] = Math.min(min[segment * 2], min[segment * 2 + 1]);
	}

	static void build(int l, int r, int segment) {
		left[segment] = l;
		right[segment] = r;

		if (l + 1 == r) {
			min[segment] = data[l];
			return;
		}

		int mid = (l + r) / 2;
		build(l, mid, segment * 2);
		build(mid, r, segment * 2 + 1);

		push_up(segment);
	}

	static int queryMin(int l, int r, int segment) {
		// ignore segment
		if (left[segment] >= r || right[segment] <= l)
			return Integer.MAX_VALUE;

		// segment completely inside range
		if (left[segment] >= l && right[segment] <= r)
			return min[segment];

		// segment partly inside range
		return Math.min(queryMin(l, r, segment * 2), queryMin(l, r, segment * 2 + 1));
	}

	static void update(int position, int value, int segment) {
		// updated position is not inside current segment
		if (left[segment] > position || right[segment] <= position) {
			return;
		}

		// is segment of size 1
		if (left[segment] + 1 == right[segment]) {
			min[segment] = value;
			return;
		}

		// check children
		update(position, value, segment * 2);
		update(position, value, segment * 2 + 1);

		// update itself
		push_up(segment);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// read input
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);

		tmp = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(tmp[i]);
		}

		// build before processing updates and queries
		build(0, n, 1);

		for (int i = 0; i < m; i++) {
			tmp = br.readLine().split(" ");
			if (tmp[0].equals("q")) {
				int l = Integer.parseInt(tmp[1]) - 1;
				int r = Integer.parseInt(tmp[2]);

				System.out.println(queryMin(l, r, 1));

			} else if (tmp[0].equals("u")) {
				int x = Integer.parseInt(tmp[1]) - 1;
				int v = Integer.parseInt(tmp[2]);

				update(x, v, 1);
			}
		}
		br.close();
	}

}