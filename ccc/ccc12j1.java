package ccc;

import java.util.Scanner;

public class ccc12j1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int c = sc.nextInt();
		if (c < l + 1) {
			System.out.println("Congratulations, you are within the speed limit!");
			return;
		}
		if (c < l + 21) {
			System.out.println("You are speeding and your fine is $100.");
			return;
		}
		if (c < l + 31) {
			System.out.println("You are speeding and your fine is $270.");
			return;
		}
		System.out.println("You are speeding and your fine is $500.");

	}
}
