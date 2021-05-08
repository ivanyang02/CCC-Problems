package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ccc03s5 {
	public static class Edge implements Comparable<Edge> {
		int ev;
		int cost;

		public Edge(int ev, int cost) {
			this.ev = ev;
			this.cost = cost;
		}

		public int compareTo(Edge o) {
			if (this.cost > o.cost) {
				return -1;
			} else if (this.cost < o.cost) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int totalcities = Integer.parseInt(st.nextToken());
		int roads = Integer.parseInt(st.nextToken());
		int destinations = Integer.parseInt(st.nextToken());
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		PriorityQueue<Edge>[] map = new PriorityQueue[totalcities];
		for (int i = 0; i < totalcities; i++) {
			map[i] = new PriorityQueue<Edge>();
		}
		for (int i = 0; i < roads; i++) {
			st = new StringTokenizer(br.readLine());
			int bv = Integer.parseInt(st.nextToken()) - 1;
			int ev = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			map[bv].add(new Edge(ev, cost));
			map[ev].add(new Edge(bv, cost));
		}
		int[] destinationcities = new int[destinations];
		for (int i = 0; i < destinations; i++) {
			destinationcities[i] = Integer.parseInt(br.readLine()) - 1;
		}
		queue.add(new Node(0, 0));
		int[] step = new int[totalcities];
		Arrays.fill(step, -1);
		step[0] = 0;
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			for (Edge e : map[current.v]) {
				if (step[e.ev] < e.cost) {
					step[e.ev] = e.cost;
					queue.add(new Node(e.ev, e.cost));
				}
			}
		}
		int smallest = Integer.MAX_VALUE;
		for (int i = 0; i < destinationcities.length; i++) {
			if (step[destinationcities[i]] < smallest) {
				smallest = step[destinationcities[i]];
			}
		}
		System.out.println(smallest);
	}

	public static class Node implements Comparable<Node> {
		int v;
		int step;

		public Node(int v, int step) {
			this.v = v;
			this.step = step;
		}

		public int compareTo(Node o) {
			if (this.step > o.step) {
				return -1;
			} else if (this.step < o.step) {
				return 1;
			} else {
				return 0;
			}
		}
	}
}
