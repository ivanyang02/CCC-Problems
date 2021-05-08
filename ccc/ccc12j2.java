package ccc;

import java.util.Scanner;

public class ccc12j2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[4];
		for (int i = 0; i < 4; i++) {
			nums[i] = sc.nextInt();
		}
		for (int i = 1; i < 4; i++) {
			if (nums[i] <= nums[i - 1]) {
				break;
			}
			if (i == 3) {
				System.out.println("Fish Rising");
				return;
			}
		}
		for (int i = 1; i < 4; i++) {
			if (nums[i] >= nums[i - 1]) {
				break;
			}
			if (i == 3) {
				System.out.println("Fish Diving");
				return;
			}
		}
		for (int i = 1; i < 4; i++) {
			if (nums[i] != nums[i - 1]) {
				break;
			}
			if (i == 3) {
				System.out.println("Fish At Constant Depth");
				return;
			}
		}
		System.out.println("No Fish");
	}
}
