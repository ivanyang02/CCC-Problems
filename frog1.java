import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class frog1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] height = new int[n];
		for (int i = 0; i < n; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		int[] minimum = new int[n];
		minimum[0] = 0;
		for (int i = 1; i < n; i++) {
			int prevCost = minimum[i - 1];
			int jumpCost = Math.abs(height[i] - height[i - 1]);
			minimum[i] = prevCost + jumpCost;
			if (i - 2 >= 0) {
				prevCost = minimum[i - 2];
				jumpCost = Math.abs(height[i] - height[i - 2]);
				int totalCost = prevCost + jumpCost;
				minimum[i] = Math.min(minimum[i], totalCost);
			}
		}
		System.out.println(minimum[n - 1]);
	}
}
