import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class strayingfromgod {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dimensions = Integer.parseInt(br.readLine());
		char[][] map = new char[dimensions][dimensions];
		long[][] step = new long[dimensions][dimensions];
		for (int i = 0; i < dimensions; i++) {
			String s = br.readLine();
			for (int j = 0; j < dimensions; j++) {
				map[i][j] = s.charAt(j);
				step[i][j] = 1 << 30;
			}
		}
		LinkedList<Integer> rqueue = new LinkedList<Integer>();
		LinkedList<Integer> cqueue = new LinkedList<Integer>();
		rqueue.add(0);
		cqueue.add(0);
		step[0][0] = 0;
		while (!rqueue.isEmpty()) {
			int curr = rqueue.poll();
			int curc = cqueue.poll();
			if (curr + 1 < dimensions && map[curr + 1][curc] != '#') {
				if (step[curr + 1][curc] > step[curr][curc] + 1) {
					step[curr + 1][curc] = step[curr][curc] + 1;
					rqueue.add(curr + 1);
					cqueue.add(curc);
				}
			}
			if (curc - 1 >= 0 && map[curr][curc - 1] != '#') {
				if (step[curr][curc - 1] > step[curr][curc] + 1) {
					step[curr][curc - 1] = step[curr][curc] + 1;
					rqueue.add(curr);
					cqueue.add(curc - 1);
				}
			}
			if (curc + 1 < dimensions && map[curr][curc + 1] != '#') {
				if (step[curr][curc + 1] > step[curr][curc] + 1) {
					step[curr][curc + 1] = step[curr][curc] + 1;
					rqueue.add(curr);
					cqueue.add(curc + 1);
				}
			}
		}
		if (step[dimensions - 1][dimensions - 1] == 1 << 30) {
			System.out.println(-1);
			return;
		}
		long sum = step[dimensions - 1][dimensions - 1] - dimensions + 1;
		long lefts = (sum - dimensions + 1) / 2;
		long rights = lefts + dimensions - 1;
		long downs = dimensions - 1;
		System.out.println(downs * downs + lefts * lefts + rights * rights);

	}
}
