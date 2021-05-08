package ccc;

import java.util.Scanner;

public class ccc19s1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int h = 0;
		int v = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'H') {
				h++;
			} else {
				v++;
			}
		}
		if (h % 2 == 0 && v % 2 == 0) {
			System.out.println("1 2");
			System.out.println("3 4");
		}
		if (h % 2 == 1 && v % 2 == 0) {
			System.out.println("3 4");
			System.out.println("1 2");
		}
		if (h % 2 == 0 && v % 2 == 1) {
			System.out.println("2 1");
			System.out.println("4 3");
		}
		if (h % 2 == 1 && v % 2 == 1) {
			System.out.println("4 3");
			System.out.println("2 1");
		}
	}
}
