import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class sawmillscheme {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int lakes = Integer.parseInt(st.nextToken());
		int rivers = Integer.parseInt(st.nextToken());
		double[] probabilities = new double[lakes + 1];
		ArrayList<Integer> adj[] = new ArrayList[lakes + 1];
		for (int i = 1; i < lakes + 1; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < rivers; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
		}
		probabilities[1] = 1;
		for (int i = 1; i < lakes + 1; i++) {
			double probability = probabilities[i] / adj[i].size();
			for (int j = 0; j < adj[i].size(); j++) {
				probabilities[adj[i].get(j)] += probability;
			}
		}

		for (int i = 1; i < lakes + 1; i++) {
			if (adj[i].size() == 0) {
				System.out.println(probabilities[i]);
			}
		}
	}
}
