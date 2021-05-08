package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ccc09s4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cityCount = Integer.parseInt(br.readLine());
		int tradeRoutes = Integer.parseInt(br.readLine());
		int[][] cityMap = new int[cityCount][cityCount];
		int[] step = new int[cityCount];
		Arrays.fill(step, Integer.MAX_VALUE);
		for (int i = 0; i < tradeRoutes; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int bv = Integer.parseInt(st.nextToken()) - 1;
			int ev = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			cityMap[bv][ev] = cost;
			cityMap[ev][bv] = cost;
		}
		int pencilCities = Integer.parseInt(br.readLine());
		int[] pencilLocations = new int[cityCount];
		for (int i = 0; i < pencilCities; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int pencilCity = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			pencilLocations[pencilCity] = cost;
		}
		int startingLocation = Integer.parseInt(br.readLine()) - 1;
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(new Node(startingLocation,0));
		step[startingLocation] = 0;
		while (!queue.isEmpty()) {
			Node curc = queue.poll();
			for (int i = 0; i < cityCount; i++) {
				if (cityMap[curc.v][i] > 0 && step[i] > step[curc.v] + cityMap[curc.v][i]) {
					step[i] = step[curc.v] + cityMap[curc.v][i];
					queue.add(new Node(i, step[i]));
				}
			}
		}
		int smallest = Integer.MAX_VALUE;
		for (int i = 0; i < pencilLocations.length; i++) {
			if (step[i] + pencilLocations[i] < smallest && pencilLocations[i] > 0) {
				smallest = step[i] + pencilLocations[i];
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

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if (this.step > o.step) {
				return 1;
			} else if (this.step < o.step) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}
