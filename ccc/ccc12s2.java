package ccc;
import java.util.Scanner;

public class ccc12s2 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String number = sc.next();
		int sum = 0;
		for(int i = 1; i < number.length(); i+=2) {
			if(number.charAt(i) == 'I') {
				sum += (int) number.charAt(i-1);
			}
			if(number.charAt(i) == 'V') {
				sum += 5*(int) number.charAt(i-1);
			}
			if(number.charAt(i) == 'X') {
				sum += 10*(int) number.charAt(i-1);
			}
			if(number.charAt(i) == 'L') {
				sum += 50*(int) number.charAt(i-1);
			}
			if(number.charAt(i) == 'C') {
				sum += 100*(int) number.charAt(i-1);
			}
			if(number.charAt(i) == 'D') {
				sum += 500*(int) number.charAt(i-1);
			}
			if(number.charAt(i) == 'M') {
				sum += 1000*(int) number.charAt(i-1);
			}
		}
		System.out.println(sum);
	}
}
