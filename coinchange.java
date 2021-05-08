import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class coinchange {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int change = Integer.parseInt(br.readLine());
		int coinamount = Integer.parseInt(br.readLine());
		int[] coins = new int[coinamount];
		int dp[] = new int[change * 2];
		Arrays.fill(dp, 1 << 30);
		dp[0] = 0;
		for (int i = 0; i < coinamount; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < change; ++i) {
			for (int j = 0; j < coinamount; ++j) {
				dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1);
			}
		}
		System.out.println(dp[change]);
	}
}
