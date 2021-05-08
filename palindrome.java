import java.util.Scanner;

public class palindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		boolean t = true;
		String start = s.substring(0, s.length() / 2 + s.length() % 2);
		String temp = s.substring(s.length() / 2, s.length());
		String end = "";
		for (int i = 0; i < temp.length(); i++) {
			end += (temp.charAt(temp.length() - i - 1));
			if (start.charAt(i) != end.charAt(i)) {
				t = false;
			}
		}
		if (t) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}
