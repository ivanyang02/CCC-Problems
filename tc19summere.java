import java.util.Scanner;

public class tc19summere {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double n = sc.nextDouble();
		double t = sc.nextDouble();
		int sum = 0;
		double newval = -1;
		for (double i = 1; i < n + 1; i++) {
			double add;
			if (newval != -1) {
				add = n - Math.abs(i - (Math.ceil((newval) / 2) + (t) * (Math.floor((i - 1) / (t)))));
			} else if (n - (t * (Math.floor((i - 1) / t))) < t) {
				newval = n - (t * (Math.floor((i - 1) / t)));
				add = n - Math.abs(i - (Math.ceil((newval) / 2) + (t) * (Math.floor((i - 1) / (t)))));
			} else {
				add = n - Math.abs(i - Math.ceil((t + 1) / 2) - t * (Math.floor((i - 1) / t)));
			}
			sum += add;
		}
		System.out.println(sum);
	}
}
