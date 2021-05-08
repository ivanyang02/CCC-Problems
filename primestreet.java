import java.io.BufferedReader;
import java.io.InputStreamReader;

public class primestreet {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = new int[250000];
		int[] primed = new int[250000];
		for (int i = 0; i < 250000; i++) {
			nums[i] = i;
		}
		boolean[] A = new boolean[250000];
		for (int i = 2; i <= Math.sqrt(250000); i++) {
			if (A[i] == false) {
				for (int j = i * i; j <= 250000; j += i) {
					A[j] = true;
				}
			}
		}
		int[] primes = new int[100000];
		int[] composites = new int[100000];
	}
}
