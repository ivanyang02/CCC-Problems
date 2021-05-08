package ccc;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class ccc04s2 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int competitors = sc.nextInt();
		int rounds = sc.nextInt();
		int[] scores = new int[competitors];
		int[] lowestrank = new int[competitors];
		Arrays.fill(lowestrank, competitors-1);
		int rank = 0;
		for(int i = 0; i < rounds; i++) {
			for(int j = 0; j < competitors; j++) {
				int score = sc.nextInt();
				scores[j] += score;
			}
			for(int j = 0; j < competitors; j++) {
				rank = 0;
				for(int k = 0; k < competitors; k++) {
					if(j != k && scores[k] > scores[j]) {
						rank++;
					}
				}
				if(rank > lowestrank[j]) {
					lowestrank[j] = rank;
				}
			}
		}
		int largest = 0;
		LinkedList<Integer> bestcompetitors = new LinkedList<Integer>();
		for(int i = 0; i < competitors; i++) {
			if(scores[i] > largest) {
				bestcompetitors.clear();
				largest = scores[i];
				bestcompetitors.add(i);
			}else 
			if(scores[i]== largest) {
				bestcompetitors.add(i);
			}
		}
		
		for(int i = 0; i < bestcompetitors.size(); i++) {
			System.out.println("Yodeller "+ (bestcompetitors.get(i)+1)+" is the TopYodeller: score " + scores[bestcompetitors.get(i)] + ", worst rank "+(lowestrank[i]+1));
		}
	}
}