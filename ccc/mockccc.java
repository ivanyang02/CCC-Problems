package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class mockccc {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int ways = 0;
		for (int i = a; i <= b; i++) {
			for (int j = c; j <= d; j++) {
				if (gcd(i, j) == 1) {
					ways++;
				}
			}
		}
		System.out.println(ways);
	}

	public static int gcd(int a, int b) {

		if (b == 0) {
			return b;
		}
		return gcd(b, a % b);
	}
}
