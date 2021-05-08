import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codeCopiers {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nums = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] copy = new boolean[nums];
		for (int i = 0; i < nums; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (a > 0) {
				copy[a] = true;
			}
		}
		int counter = 0;
		for (int i = 0; i < nums; i++) {
			if (copy[i] == false) {
				counter++;
			}
		}
		System.out.println(counter);

	}
}
