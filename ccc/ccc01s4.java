package ccc;
import java.util.Scanner;
import java.util.Arrays;
public class ccc01s4 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int points = sc.nextInt();
		int[] xvalues = new int[points];
		int[] yvalues = new int[points];
		for(int i = 0; i < points; i++) {
			xvalues[i] = sc.nextInt();
			yvalues[i] = sc.nextInt();
		}
		Arrays.sort(xvalues);
		Arrays.sort(yvalues);
		double xavg = ((double)xvalues[0]+(double)xvalues[points-1])/2;
		double yavg = ((double)yvalues[0]+(double)yvalues[points-1])/2;
		System.out.println(xavg +", "+ yavg);
		double largestdistance = 0;
		for(int i = 0; i < points; i++) {
			double xdistance = (Math.abs(xvalues[i])-Math.abs(xavg));
			double ydistance = (Math.abs(yvalues[i])-Math.abs(yavg));
			if(xdistance+ydistance > largestdistance) {
				largestdistance = Math.sqrt(Math.pow(xdistance,2)+Math.pow(ydistance,2));
			}
		}
		System.out.println(largestdistance*2);
	}
}
