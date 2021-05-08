import java.util.Scanner;

public class tc19summerd {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int[] events = new int[a];
		for (int i = 0; i < b; i++) {
			int q = sc.nextInt();
			events[q] = 1;
		}
		for(int i = 0; i < a; i++) {
			
		}
		int theoreticalmax = (a - b) / c;
		int max = 0;
		System.out.println(theoreticalmax * c);
	}
}
