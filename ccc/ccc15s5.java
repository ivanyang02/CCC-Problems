package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc15s5 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int[] original = new int[a];
		for (int i = 0; i < a; i++) {
			original[i] = Integer.parseInt(br.readLine());
		}
		int b = Integer.parseInt(br.readLine());
		int[] ne = new int[b];
		for (int i = 0; i < b; i++) {
			ne[i] = Integer.parseInt(br.readLine());
		}
		int[] max = new int[a + b];
		if (b == 0) {
			max[0] = original[0];
			max[1] = original[1];
			for (int i = 2; i < max.length; i++) {
				max[i] = Math.max(max[i - 2] + original[i], original[i - 1]);
			}
			System.out.println(Math.max(max[a - 1], max[a - 2]));
		}
	}
}
