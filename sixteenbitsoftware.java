import java.util.Scanner;

public class sixteenbitsoftware {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			long ans = sc.nextLong();
			if(a*b == ans) {
				System.out.println("POSSIBLE DOUBLE SIGMA");
			}else {
				System.out.println("16 BIT S/W ONLY");
			}
		}
	}
}
