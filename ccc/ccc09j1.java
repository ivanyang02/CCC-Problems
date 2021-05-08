package ccc;

import java.util.Scanner;

public class ccc09j1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 91;
		sum += sc.nextInt();
		sum += sc.nextInt() * 3;
		sum += sc.nextInt();
		System.out.println("The 1-3-sum is " + sum);
	}
}
