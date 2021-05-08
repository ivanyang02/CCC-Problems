package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc15s3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int g = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		int[] gates = new int[g];
		for (int i = 0; i < p; i++) {
			int maxgate = Integer.parseInt(br.readLine()) - 1;
			for (int j = maxgate; j >= -1; j--) {
				if (j == -1) {
					System.out.println(i);
					System.exit(0);
				}
				if (gates[j] == 0) {
					gates[j]++;
					break;
				}
			}
		}
		System.out.println(g);
	}
}
