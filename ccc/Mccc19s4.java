package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Mccc19s4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int purchases = Integer.parseInt(br.readLine());
		Food[] foods = new Food[4];
		foods[0] = (new Food("Deluxe Tuna Bitz", 0, 0));
		foods[1] = (new Food("Bonito Bitz", 0, 1));
		foods[2] = (new Food("Sashimi", 0, 2));
		foods[3] = (new Food("Ritzy Bitz", 0, 3));
		for (int i = 0; i < purchases; i++) {
			String purchase = br.readLine();
			if (purchase.charAt(0) == 'D') {
				foods[0].amount++;
			}else if (purchase.charAt(0) == 'B') {
				foods[1].amount++;
			}else if (purchase.charAt(0) == 'S') {
				foods[2].amount++;
			}else {
				foods[3].amount++;
			}
		}
		Arrays.sort(foods);
		for (int i = 0; i < foods.length; i++) {
			if (foods[i].amount > 0) {
				System.out.println(foods[i].name + " " + foods[i].amount);
			}
		}
	}

	public static class Food implements Comparable<Food> {
		String name;
		int amount;
		int orderid;

		public Food(String name, int amount, int orderid) {
			this.name = name;
			this.amount = amount;
			this.orderid = orderid;
		}

		public int compareTo(Food o) {
			if (this.amount > o.amount) {
				return -1;
			} else if (this.amount < o.amount) {
				return 1;
			} else {
				if (this.orderid > o.orderid) {
					return 1;
				} else {
					return -1;
				}
			}
		}
	}
}
