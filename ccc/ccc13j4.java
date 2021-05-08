package ccc;
import java.util.Scanner;
import java.util.Arrays;
public class ccc13j4 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int time = sc.nextInt();
		int allowed = 0;
		int totaltime = 0;
		int chorecount = sc.nextInt();
		int[] chores = new int[chorecount];
		for(int i = 0; i < chorecount; i++) {
			chores[i] = sc.nextInt();
		}
		Arrays.sort(chores);
		for(int i = 0; i < chorecount; i++) {
			if(totaltime + chores[i] <= time) {
				allowed++;
				totaltime+= chores[i];
			}
			}
		System.out.println(allowed);
	}
}
