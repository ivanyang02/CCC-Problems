package ccc;

import java.util.Scanner;

public class ccc18s4 {
	static long sum;
	static long[] temp;

	public static long calc(int a) {
		if (a <= 2) {
			return 1;
		} else if (temp[a] != 0) {
			return temp[a];
		} else {
			long count = a - a / 3;
			for (int i = 2; i <= a / 3; i++) {
				count += calc(a / i);
			}
			temp[a] = count;
			return count;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		temp = new long[a + 1];
		sum = calc(a);
		System.out.print(sum);
	}
}
