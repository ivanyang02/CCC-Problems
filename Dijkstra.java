import java.util.Scanner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Dijkstra {
	public static class Node implements Comparable<Node> {
		int e;
		int w;

		public Node(int e, int w) {
			this.e = e;
			this.w = w;
		}
		@Override
		
		public int compareTo(Node o) {
			if (this.w > o.w) {
				return 1;
			}
			if (this.w < o.w) {
				return -1;
			}
			return 0;
		}
	}

	public static void main(String[] Args) {
		Scanner sc = new Scanner(System.in);
		int vertexes = sc.nextInt();
		int edges = sc.nextInt();
		int[][] map = new int[vertexes][vertexes];
		for (int i = 0; i < edges; i++) {
			int bv = sc.nextInt()-1;
			int ev = sc.nextInt()-1;
			int weight = sc.nextInt();
			map[bv][ev] = weight;
			map[ev][bv] = weight;
		}
		int[] step = new int[vertexes];
		Arrays.fill(step, Integer.MAX_VALUE);
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		step[0] = 0;
		queue.add(new Node(0, 0));
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			int v = current.e;
			for (int i = 0; i < vertexes; i++) {
				if (map[v][i] > 0 && step[i] > current.w + map[v][i]) {
					step[i] = current.w + map[v][i];
					queue.add(new Node(i, step[i]));
				}
			}
		}
		for (int i = 0; i < vertexes; i++) {
			System.out.println(step[i]);
		}
	}
}
