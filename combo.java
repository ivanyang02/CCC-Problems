import java.util.Scanner;

public class combo {
	static String s;

	public static String guess_sequence(int N) {
		String guess = "";
		if (press("A") == 1) {
			guess += "A";
		} else if (press("B") == 1) {
			guess += "B";
		} else if (press("X") == 1) {
			guess += "X";
		} else {
			guess += "Y";
		}
		for (int i = 0; i < N - 1; i++) {
			int length = guess.length();
			if (guess.charAt(0) == 'A') {
				if (press(guess + "BB") == length + 2) {
					guess += "B";
				} else if (press(guess + "BX") == length + 2) {
					guess += "B";
				} else if (press(guess + "BY") == length + 2) {
					guess += "B";
				} else if (press(guess + "X") == length + 1) {
					guess += "X";
				} else {
					guess += "Y";
				}
			} else if (guess.charAt(0) == 'B') {
				if (press(guess + "AA") == length + 2) {
					guess += "A";
				} else if (press(guess + "AX") == length + 2) {
					guess += "A";
				} else if (press(guess + "AY") == length + 2) {
					guess += "A";
				} else if (press(guess + "X") == length + 1) {
					guess += "X";
				} else {
					guess += "Y";
				}
			} else if (guess.charAt(0) == 'X') {
				if (press(guess + "BA") == length + 2) {
					guess += "B";
				} else if (press(guess + "BB") == length + 2) {
					guess += "B";
				} else if (press(guess + "BY") == length + 2) {
					guess += "B";
				} else if (press(guess + "A") == length + 1) {
					guess += "A";
				} else {
					guess += "Y";
				}
			} else if (guess.charAt(0) == 'Y') {
				if (press(guess + "BB") == length + 2) {
					guess += "B";
				} else if (press(guess + "BX") == length + 2) {
					guess += "B";
				} else if (press(guess + "BA") == length + 2) {
					guess += "B";
				} else if (press(guess + "X") == length + 1) {
					guess += "X";
				} else {
					guess += "A";
				}
			}
		}
		return guess;
	}

	public static int press(String p) {
		for (int i = s.length(); i >= 0; i--) {
			if (p.contains(s.substring(0, i))) {
				return s.substring(0, i).length();
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.next();
		int N = s.length();
		System.out.println(guess_sequence(N));
	}
}
