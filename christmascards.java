import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class christmascards {
	public static class card {
		int cost;
		int draw;

		public card(int cost, int draw) {
			this.cost = cost;
			this.draw = draw;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cardcount = Integer.parseInt(br.readLine());
		LinkedList<card> deck = new LinkedList<card>();
		LinkedList<card> hand = new LinkedList<card>();
		int[] drawncards = new int[cardcount * 2];
		Arrays.fill(drawncards, 1 << 30);
		drawncards[0] = 0;
		StringTokenizer st;
		for (int i = 0; i < cardcount; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int draw = Integer.parseInt(st.nextToken());
			deck.add(new card(cost, draw));
		}
		for (int i = 0; i < cardcount; i++) {
			for (int j = 0; j < hand.size(); j++) {
				drawncards[i + hand.get(j).draw] = Math.min(drawncards[i + hand.get(j).draw],
						drawncards[i] + hand.get(j).cost);
			}
		}
	}
}
