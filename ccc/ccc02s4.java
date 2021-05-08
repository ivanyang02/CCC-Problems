package ccc;
import java.util.Scanner;
import java.util.Arrays;
public class ccc02s4 {
	public static Edge[] edge;

	public static class Edge implements Comparable<Edge> {
		String name;
		int time;

		// constructor name is the same as class name
		public Edge() {
		}

		public Edge(String name, int time) {
			this.name = name;
			this.time = time;

		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			if (this.time > o.time) {
				return -1; // positive (you greater than the object
				// you compare
			} else if (this.time < o.time) {
				return 1; // negative (you smaller than the object
				// you compare
			} else {
				return 0; // zero (you and the object you compare
				// are equals
			}
		}
	}
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int groupsize = sc.nextInt();
		int numberofpeople = sc.nextInt();
		edge = new Edge[numberofpeople];
		int extra = 0;
		if(numberofpeople%groupsize !=0) {
			extra = 1;
		}
		String[][] groups = new String[numberofpeople/groupsize+extra][groupsize];
		for(int i = 0; i < numberofpeople; i++) {
			edge[i] = new Edge(sc.next(),sc.nextInt());
		}
		Arrays.sort(edge);
		int x=0;
		for(int i = 0; i < numberofpeople/groupsize+extra; i++) {
			for(int j = 0; j < groupsize; j++) {
				groups[i][j]=edge[x].name;
				x+=1;
			}
		}
		for(int i = 0; i < numberofpeople/groupsize+extra; i++) {
			for(int j = 0; j < groupsize; j++) {
				System.out.print(groups[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
