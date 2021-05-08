package ccc;

import java.util.Scanner;

public class ccc10j1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int amount = 0;
			for (int i = 0; i < n / 2 + 1; i++) {
				if (n - i >= i && n - i <= 5) {
					amount++;
				}
			}

		System.out.println(amount);

	}
}
