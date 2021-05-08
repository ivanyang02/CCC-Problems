import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class goodnumbers {
	public static boolean isprime(double number) {
		if (number == 1 || number == 0) {
			return false;
		} else if (number == 3 || number == 2) {
			return true;
		} else if (number % 2 == 0) {
			return false;
		} else {
			for (int j = 3; j < number; j += 2) {
				if (number % j == 0) {
					return false;
				}
			}
			return true;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numbers = Integer.parseInt(br.readLine());
		int goodnumbers = 0;
		for (int i = 0; i < numbers; i++) {
			String thenumber = br.readLine();
			double number = Double.parseDouble(thenumber);
			double digitsum = 0;
			for (int j = 0; j < thenumber.length(); j++) {
				digitsum += Double.parseDouble(Character.toString(thenumber.charAt(j)));
			}
			if (isprime(number) == true && isprime(digitsum) == true) {
				goodnumbers++;
			}
		}
		System.out.println(goodnumbers);
	}
}
