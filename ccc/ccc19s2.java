package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc19s2 {
	public static boolean isPrime(int n) {
		double num = n;
		if (num % 2 == 0) {
			return false;
		}
		for (int i = 3; i <= Math.sqrt(num); i += 2) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcases = Integer.parseInt(br.readLine());
		for (int i = 0; i < testcases; i++) {
			int n = Integer.parseInt(br.readLine());
			int a = n;
			int b = n;
			if (a % 2 == 0) {
				a++;
				b--;
			}
			while (true) {
				if (isPrime(a) && isPrime(b)) {
					System.out.println(a + " " + b);
					break;
				}
				a += 2;
				b -= 2;
			}
		}
	}
}
