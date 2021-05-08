import java.util.Arrays;
import java.util.Scanner;
public class abArrays {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int arraylen = sc.nextInt();
		float[] a = new float[arraylen];
		float[] b = new float[arraylen];
		for (int i = 0; i < arraylen; i++) {
			a[i] = sc.nextFloat();
		}
		b[0] = a[0];
		for(int i = 1; i < arraylen; i++) {
			b[i]=b[i-1]+a[i];
		}
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}
}
