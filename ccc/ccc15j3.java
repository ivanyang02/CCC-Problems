package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc15j3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			System.out.print(s.charAt(i));
			if (s.charAt(i) != 'a' && s.charAt(i) != 'e' && s.charAt(i) != 'i' && s.charAt(i) != 'o'
					&& s.charAt(i) != 'u') {
				if (s.charAt(i) == 'b' || s.charAt(i) == 'c') {
					System.out.print("a");
				} else if (s.charAt(i) == 'd' || s.charAt(i) == 'f' || s.charAt(i) == 'g') {
					System.out.print("e");
				} else if (s.charAt(i) == 'h' || s.charAt(i) == 'j' || s.charAt(i) == 'k' || s.charAt(i) == 'l') {
					System.out.print("i");
				} else if (s.charAt(i) == 'm' || s.charAt(i) == 'n' || s.charAt(i) == 'p' || s.charAt(i) == 'q'
						|| s.charAt(i) == 'r') {
					System.out.print("o");
				} else {
					System.out.print("u");
				}
				if (s.charAt(i) == 'd' || s.charAt(i) == 'h' || s.charAt(i) == 'n' || s.charAt(i) == 't') {
					System.out.print((char) (s.charAt(i) + 2));
				} else if (s.charAt(i) == 'z') {
					System.out.print('z');
				} else {
					System.out.print((char) (s.charAt(i) + 1));
				}
			}

		}
	}
}
