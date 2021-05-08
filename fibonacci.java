import java.util.Arrays;

public class fibonacci {
	static long[] dp = new long[100];

	static long fibonacci(int n) {
		if (n <= 2) {
			return 1;
		}
		if (dp[n] != 0) {
			return dp[n];
		}
		dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
		return dp[n];
	}

	public static void main(String[] args) {
		int a = 50;
		System.out.println(fibonacci(a));
	}
}
