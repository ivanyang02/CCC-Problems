import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class brackets {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		char[] string = a.toCharArray();
		int openpairs = 0;
		int spaces = 0;
		boolean valid = true;
		if (string.length % 2 != 0) {
			valid = false;
		}
		for (int i = 0; i < string.length; i++) {
			if (string[i] == '(') {
				openpairs++;
			} else if (string[i] == ')') {
				openpairs--;
			} else {
				spaces++;
			}
			if (openpairs < 0 && Math.abs(openpairs) > spaces) {
				valid = false;
				break;
			}
		}
		for (int i = 0; i < string.length; i++) {
			if (string[i] == '?') {
				if (openpairs == spaces) {
					string[i] = ')';
					openpairs--;
					spaces--;
				} else {
					string[i] = '(';
					openpairs++;
					spaces--;
				}
			}
		}
		if (valid == true) {
			for (int i = 0; i < string.length; i++) {
				System.out.print(string[i]);
			}
		} else {
			System.out.println("invalid");
		}
	}
}