package ccc;

import java.util.Arrays;
import java.util.Scanner;

public class ccc01j1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		char[][] tie = new char[h][2 * h];
		for (int i = 0; i < h; i++) {
			Arrays.fill(tie[i], ' ');
		}
		for (int i = 0; i < h / 2 + 1; i++) {
			for (int j = 0; j < 2 * i + 1; j++) {
				tie[i][j] = '*';
				tie[i][2 * h - j - 1] = '*';
				tie[h - i - 1][j] = '*';
				tie[h - i - 1][2 * h - j - 1] = '*';
			}
		}
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < 2 * h; j++) {
				System.out.print(tie[i][j]);
			}
			System.out.println("");
		}
	}
}
