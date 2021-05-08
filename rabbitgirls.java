import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class rabbitgirls {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int groups = n / k;
		int leftover = n - ((n / k) * k);
		if (groups == 0) {
			System.out.println(k - leftover);
		} else if (k - leftover < leftover) {
			System.out.println(k - leftover);
		} else {
			System.out.println(leftover);
		}
	}
}
