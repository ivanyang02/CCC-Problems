package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ccc10s4 {
	public static class Edge {
		int bv;
		int ev;
		int cost;

		public Edge(int bv, int ev, int cost) {
			this.bv = bv;
			this.ev = ev;
			this.cost = cost;
		}

		public boolean equals(Edge o) {
			if (((this.bv == o.bv && this.ev == o.ev) || (this.bv == o.ev && this.ev == o.bv)) && this.cost == o.cost) {
				return true;
			} else {
				return false;
			}
		}

	}

	public static class Pen {
		int edgecount;
		Edge[] edges;
		Boolean[] connectededges;

		public Pen(int edgecount) {
			this.edgecount = edgecount;
			this.edges = new Edge[edgecount];
			this.connectededges = new Boolean[edgecount];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int pencount = Integer.parseInt(br.readLine());
		Pen[] pens = new Pen[pencount];
		for (int i = 0; i < pencount; i++) {
			st = new StringTokenizer(br.readLine());
			int fencecount = Integer.parseInt(st.nextToken());
			pens[i] = new Pen(fencecount);
			int[] vertexes = new int[fencecount];
			int[] weight = new int[fencecount];
			for (int j = 0; j < fencecount; j++) {
				vertexes[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < fencecount; j++) {
				weight[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < fencecount; j++) {
				if (j == fencecount - 1) {
					pens[i].edges[j] = new Edge(vertexes[j], vertexes[0], weight[j]);
				} else {
					pens[i].edges[j] = new Edge(vertexes[j], vertexes[j + 1], weight[j]);
				}
				pens[i].connectededges[j] = false;
			}
		}
		int[][] map = new int[pencount][pencount];
		int[][] outermap = new int[pencount + 1][pencount + 1];
		for (int i = 0; i < pencount; i++) {
			Arrays.fill(map[i], -1);
			Arrays.fill(outermap[i], -1);
		}
		Arrays.fill(outermap[pencount], -1);
		for (int i = 0; i < pencount; i++) {
			for (int j = 0; j < pencount; j++) {
				if (i != j) {
					for (int k = 0; k < pens[i].edgecount; k++) {
						for (int l = 0; l < pens[j].edgecount; l++) {
							if (pens[i].edges[k].equals(pens[j].edges[l])) {
								map[i][j] = pens[i].edges[k].cost;
								map[j][i] = pens[i].edges[k].cost;
								outermap[i][j] = pens[i].edges[k].cost;
								outermap[j][i] = pens[i].edges[k].cost;
								pens[i].connectededges[k] = true;
								pens[j].connectededges[l] = true;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < pencount; i++) {
			for (int j = 0; j < pens[i].edgecount; j++) {
				if (pens[i].connectededges[j] == false) {
					outermap[i][pencount] = pens[i].edges[j].cost;
					outermap[pencount][i] = pens[i].edges[j].cost;
				}

			}
		}
		for (int i = 0; i < pencount; i++) {
			for (int j = 0; j < pencount; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println("");
		}
		for (int i = 0; i < pencount + 1; i++) {
			for (int j = 0; j < pencount + 1; j++) {
				System.out.print(outermap[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
