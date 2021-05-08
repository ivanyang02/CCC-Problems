import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;

public class simonMarcy {
	static Scanner sc = new Scanner(System.in);
	static int requiredtotal = sc.nextInt();
	static int clubcount = sc.nextInt();
	static int[] clubs = new int[clubcount];
	static int sum = 0;
	static int swings = 0;
	static int smallestsum = Integer.MAX_VALUE;
	static int smallestswings = Integer.MAX_VALUE;

	public static void calculate(int prev) {
		swings++;
		for (int i = 0; i < clubcount; i++) {
			if (sum + clubs[i] < requiredtotal) {
				sum += clubs[i];
				calculate(clubs[i]);
			}
			if (sum + clubs[i] == requiredtotal) {
				if (swings < smallestswings) {
					smallestswings = swings;
				}
				smallestsum = sum + clubs[i];
				return;
			}
		}
			sum -= prev;
		swings--;
	}

	public static void main(String[] args) {
		for (int i = 0; i < clubcount; i++) {
			clubs[i] = sc.nextInt();
		}
		Arrays.sort(clubs);
		reverse(clubs);
		calculate(0);
		if (smallestswings < Integer.MAX_VALUE) {
			System.out.println("Roberta wins in " + (smallestswings) + " strokes.");
		} else {
			System.out.println("Roberta acknowledges defeat.");
		}
	}

	private static void reverse(int[] clubs2) {
		int[] temparray = new int[clubcount];
		for(int i = 0; i < clubcount; i++) {
			temparray[i]=clubs2[clubcount-1-i];
		}
		for(int i = 0; i < clubcount; i++) {
			clubs[i] = temparray[i];
		}
}
