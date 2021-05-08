package ccc;

import java.util.Scanner;

public class ccc14j2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		String votes = sc.next();
		int a = 0;
		int b = 0;
		for (int i = 0; i < v; i++) {
			if (votes.charAt(i) == 'A') {
				a++;
			} else {
				b++;
			}
		}
		if (a > b) {
			System.out.println("A");
		} else if (a < b) {
			System.out.println("B");
		} else {
			System.out.println("Tie");
		}
	}
}
