package ccc;

import java.util.Scanner;

public class ccc12j4 {
	static int k = 0;

	public static class letter {
		int intvalue;
		int overflow;
		int pos;

		public letter(char coded, int pos) {
			this.intvalue = coded;
			this.overflow = intvalue - 65;
			this.pos = pos;
		}

		void decode() {
			overflow = k - overflow;
			if (overflow > 0) {
				intvalue = 91 - overflow;
			} else {
				intvalue -= k;
			}
			overflow = intvalue - 65;
			overflow = 3 * pos - overflow;
			if (overflow > 0) {
				intvalue = 91 - overflow;
			} else {
				intvalue -= 3 * pos;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		String codechars = sc.next();
		letter[] code = new letter[codechars.length()];
		for (int i = 0; i < codechars.length(); i++) {
			code[i] = new letter(codechars.charAt(i), i);
			code[i].decode();
		}
		for (int i = 0; i < codechars.length(); i++) {
			System.out.println((char) code[i].intvalue);
		}
	}
}
