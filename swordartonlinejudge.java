import java.math.BigDecimal;
import java.util.Scanner;

public class swordartonlinejudge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		BigDecimal ans = new BigDecimal(0);
		for (double i = 1; i <= a; i++) {
			ans = ans.add(new BigDecimal(Math.pow(i, 6)));
		}
		ans = ans.remainder(new BigDecimal(1000000000));
		System.out.println(ans);
	}
}