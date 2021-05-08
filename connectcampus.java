import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class connectcampus {
	public static class node {
		int num;
		double x;
		double y;

		public node(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}

	public static class edge implements Comparable<edge> {
		int s;
		int e;
		double dist;

		public edge(int s, int e, double dist) {
			this.s = s;
			this.e = e;
			this.dist = dist;
		}

		public int compareTo(edge o) {
			if (this.dist > o.dist) {
				return 1;
			} else if (this.dist < o.dist) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		node[] nodes = new node[n + 1];

		double edges[][] = new double[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			Arrays.fill(edges[i], -1);
			st = new StringTokenizer(br.readLine());
			nodes[i] = new node(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = i + 1; j < n + 1; j++) {
				double dist = Math.sqrt((nodes[i].x - nodes[j].x) * (nodes[i].x - nodes[j].x)
						+ (nodes[i].y - nodes[j].y) * (nodes[i].y - nodes[j].y));
				edges[i][j] = dist;
				edges[j][i] = dist;
			}
		}

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edges[a][b] = 0;
			edges[b][a] = 0;
		}

		LinkedList<Integer> queue = new LinkedList<Integer>();
		PriorityQueue<edge> connections = new PriorityQueue<edge>();
		boolean[] mst = new boolean[n + 1];
		queue.add(1);
		double totaldist = 0;
		mst[1] = true;
		while (!queue.isEmpty()) {
			int curv = queue.poll();
			for (int i = 1; i < n + 1; i++) {
				if (edges[curv][i] != -1) {
					connections.add(new edge(curv, i, edges[curv][i]));
				}
			}
			for (int i = 0; i < connections.size(); i++) {
				edge curedge = connections.poll();
				if (mst[curedge.e] != true) {
					if (curedge.dist != 0) {
						System.out.println(curv + " " + curedge.e);
					}
					mst[curedge.e] = true;
					queue.add(curedge.e);
					totaldist += curedge.dist;
					break;
				}
			}
		}
		System.out.printf("%.2f", totaldist);
	}
}

