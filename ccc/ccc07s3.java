package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ccc07s3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int studentcount = Integer.parseInt(br.readLine());
		int[] friends = new int[10000];
		StringTokenizer st;
		for (int i = 0; i < studentcount; i++) {
			st = new StringTokenizer(br.readLine());
			friends[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == 0 && b == 0) {
				return;
			}
			int nextstudent = a;
			int distance = -1;
			while (true) {
				nextstudent = friends[nextstudent];
				distance++;
				if (nextstudent == b) {
					System.out.println("Yes " + distance);
					break;
				}
				if (nextstudent == a) {
					System.out.println("No");
					break;
				}
			}
		}
	}
}