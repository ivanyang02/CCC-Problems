package ccc;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class ccc08s3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int times = sc.nextInt();
		for (int q = 0; q < times; q++) {
			int rows = sc.nextInt();
			int columns = sc.nextInt();
			char[][] maze = new char[rows][columns];
			for (int i = 0; i < rows; i++) {
				String aString = sc.next();
				maze[i] = aString.toCharArray();
			}
			int[][] step = new int[rows][columns];
			for (int i = 0; i < rows; i++) {
				Arrays.fill(step[i], Integer.MAX_VALUE);
			}
			LinkedList<Integer> xqueue = new LinkedList<Integer>();
			LinkedList<Integer> yqueue = new LinkedList<Integer>();
			xqueue.add(0);
			yqueue.add(0);
			step[0][0] = 0;
			while (!xqueue.isEmpty() && !yqueue.isEmpty()) {
				int curx = xqueue.poll();
				int cury = yqueue.poll();
				if ((maze[cury][curx] == '-' || maze[cury][curx] == '+') && curx - 1 >= 0
						&& step[cury][curx - 1] > step[cury][curx] + 1) {
					step[cury][curx - 1] = step[cury][curx] + 1;
					xqueue.add(curx - 1);
					yqueue.add(cury);
				}
				if ((maze[cury][curx] == '-' || maze[cury][curx] == '+') && curx + 1 < columns
						&& step[cury][curx + 1] > step[cury][curx] + 1) {
					step[cury][curx + 1] = step[cury][curx] + 1;
					xqueue.add(curx + 1);
					yqueue.add(cury);
				}
				if ((maze[cury][curx] == '|' || maze[cury][curx] == '+') && cury - 1 >= 0
						&& step[cury - 1][curx] > step[cury][curx] + 1) {
					step[cury - 1][curx] = step[cury][curx] + 1;
					xqueue.add(curx);
					yqueue.add(cury - 1);
				}
				if ((maze[cury][curx] == '|' || maze[cury][curx] == '+') && cury + 1 < rows
						&& step[cury + 1][curx] > step[cury][curx] + 1) {
					step[cury + 1][curx] = step[cury][curx] + 1;
					xqueue.add(curx);
					yqueue.add(cury + 1);
				}
			}
			if (step[rows - 1][columns - 1] == Integer.MAX_VALUE || maze[rows - 1][columns - 1] == '*') {
				System.out.println(-1);
			} else {
				System.out.println(step[rows - 1][columns - 1] + 1);
			}
		}
	}
}
