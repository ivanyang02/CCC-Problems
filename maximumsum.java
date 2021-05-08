import java.util.Scanner;

public class maximumsum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] max = new int[n];
		max[0] = sc.nextInt();
		max[1] = Math.max(max[0], sc.nextInt());
		for (int i = 2; i < n; i++) {
			max[i] = Math.max(sc.nextInt() + max[i - 2], max[i - 1]);
		}
		System.out.println(max[n - 1]);
	}
}
