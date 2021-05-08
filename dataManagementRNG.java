import java.io.InputStreamReader;
import java.util.Scanner;

public class dataManagementRNG {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10000; j++) {
				int a = (int) (Math.random() * 25) + 1;
				System.out.printf("%1$4s", a);
				if (a <= 2) {
					System.out.println("     " + j);
					break;
				}
			}
		}
	}
}