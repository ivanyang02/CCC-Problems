import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class markgambling {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int markamount = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		double[] marks = new double[markamount];
		double average = 0;
		for (int i = 0; i < markamount; i++) {
			marks[i] = Double.parseDouble(st.nextToken());
			average += marks[i];
		}
		average /= markamount;
		double aboves = 0;
		for (int i = 0; i < markamount; i++) {
			if (marks[i] > average) {
				aboves++;
			}
		}
		if (aboves / markamount > 0.5) {
			System.out.println("Winnie should take the risk");
		} else {
			System.out.println("That's too risky");
		}
	}
}
