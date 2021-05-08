package ccc;

import java.util.Scanner;

public class ccc12j3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int scale = sc.nextInt();
		char[][] icon = { { '*', 'x', '*' }, { ' ', 'x', 'x' }, { '*', ' ', '*' } };
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < scale; k++) {
				for (int j = 0; j < 3; j++) {
					for (int l = 0; l < scale; l++) {
						System.out.print(icon[i][j]);
					}
				}
				System.out.println("");
			}
		}
	}
}
