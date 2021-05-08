package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ccc00j1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int startday = Integer.parseInt(st.nextToken());
		int days = Integer.parseInt(st.nextToken());
		// System.out.println(startday);
		// System.out.println(days);
		System.out.println("Sun Mon Tue Wed Thr Fri Sat");
		int day = 2 - startday;
		outer_loop: for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (day > days) {
					break outer_loop;
				}
				if (day > 0) {
					if (j == 0) {
						System.out.printf("%3s", Integer.toString(day));
					} else {
						System.out.print(" ");
						System.out.printf("%3s", Integer.toString(day));
					}
				} else {
					if (j == 0) {
						System.out.printf("%3s", "");
					} else {
						System.out.print(" ");
						System.out.printf("%3s", "");
					}
				}
				if (j == 6) {
					System.out.println("");
				}
				day++;
			}
		}
		if ((day - 1) % 7 != 0) {
			System.out.println("");
		}
	}

}
