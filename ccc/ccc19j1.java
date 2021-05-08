package ccc;

import java.util.Scanner;

public class ccc19j1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a3 = sc.nextInt();
		int a2 = sc.nextInt();
		int a1 = sc.nextInt();
		int b3 = sc.nextInt();
		int b2 = sc.nextInt();
		int b1 = sc.nextInt();
		int applescore = a3 * 3 + a2 * 2 + a1;
		int bananascore = b3 * 3 + b2 * 2 + b1;
		if (applescore > bananascore) {
			System.out.println("A");
		}
		if (bananascore > applescore) {
			System.out.println("B");
		} else {
			System.out.println("T");
		}
	}
}
