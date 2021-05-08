import java.util.Scanner;

public class firsthalfalphabet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int counter = 0;
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int num = s.charAt(i) - 'A';
			if (num >= 0 && num < N) {
				counter++;
			}
		}
		System.out.println(counter);
	}
}
