import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class adjacentlistdijkstra{
	public static class Edge{
		int ev;
		int cost;
		public Edge(int ev, int cost){
			this.ev = ev;
			this.cost = cost;
		}
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		ArrayList<Edge>[]map = new ArrayList[V];
		for(int i = 0; i < V; i++){
			map[i]= new ArrayList<Edge>();
		}
		for(int i = 0; i < E; i++){
			int bv = sc.nextInt();
			int ev = sc.nextInt();
			int cost = sc.nextInt();
			map[bv].add(new Edge(ev,cost));
		}
		int[] step = new int[V];
		Arrays.fill(step, Integer.MAX_VALUE);
		step[0] = 0;
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(new Node(0,0));
		while(!queue.isEmpty()){
			Node current = queue.poll();
			for(Edge e:map[current.v]){
				if(step[e.ev] > step[current.v]+e.cost){
					step[e.ev] = step[current.v]+e.cost;
					queue.add(new Node(e.ev, e.cost));
				}
			}
		}
		for(int i:step) {
			System.out.println(i);
		}
		
	}
	public static class Node implements Comparable<Node>{
		int v;
		int step;
		public Node(int v, int step){
			this.v = v;
			this.step = step;
		}
		public int compareTo(Node o){
			if(this.step > o.step){
				return 1;
			}
			else if(this.step < o.step){
				return -1;
			}else{
				return 0;
			}
		}
	}
}