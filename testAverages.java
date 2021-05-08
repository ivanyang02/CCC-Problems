import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class testAverages {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int average = k * n;
		int totaltime = 0;
		PriorityQueue<Node> marks = new PriorityQueue<Node>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			marks.add(new Node(a, b));
			average -= a;
		}
		if (average <= 0) {
			System.out.println(0);
		} else {
			outer_loop: while (true) {
				Node mark = marks.poll();
				int a = mark.amount;
				int b = mark.time;
				while (a < m) {
					a++;
					average--;
					totaltime += b;
					if (average == 0) {
						System.out.println(totaltime);
						break outer_loop;
					}
				}
			}
		}

	}

	public static class Node implements Comparable<Node> {
		int amount;
		int time;

		public Node(int amount, int time) {
			this.amount = amount;
			this.time = time;
		}

		public int compareTo(Node o) {
			if (this.time > o.time) {
				return 1;
			} else if (this.time < o.time) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}
