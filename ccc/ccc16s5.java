package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ccc16s5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int length = Integer.parseInt(st.nextToken());
		long cycles = Long.parseLong(st.nextToken());
		String a = br.readLine();
		boolean[] strip = new boolean[length];
		boolean[] tempstrip = new boolean[length];
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == '0') {
				strip[i] = false;
			} else {
				strip[i] = true;
			}
		}
		for (long i = 0; i < cycles; i++) {
			for (int j = 0; j < strip.length; j++) {
				tempstrip[j] = strip[j];
			}
			for (int j = 0; j < strip.length; j++) {
				if (j == 0) {
					if ((tempstrip[tempstrip.length - 1] == true && tempstrip[1] == true)
							|| (tempstrip[tempstrip.length - 1] == false && tempstrip[1] == false)) {
						strip[j] = false;
					} else {
						strip[j] = true;
					}
				} else if (j == tempstrip.length - 1) {
					if ((tempstrip[tempstrip.length - 2] == true && tempstrip[0] == true)
							|| (tempstrip[tempstrip.length - 2] == false && tempstrip[0] == false)) {
						strip[j] = false;
					} else {
						strip[j] = true;
					}
				} else if ((tempstrip[j + 1] == true && tempstrip[j - 1] == true)
						|| (tempstrip[j + 1] == false && tempstrip[j - 1] == false)) {
					strip[j] = false;
				} else {
					strip[j] = true;
				}
			}
		}
		for (int i = 0; i < strip.length; i++) {
			if (strip[i] == true) {
				System.out.print(1);
			} else {
				System.out.print(0);
			}
		}
	}
}
