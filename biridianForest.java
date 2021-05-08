import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;
public class biridianForest {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int columns = sc.nextInt();
		int battles = 0;
		int requiredstep = 0;
		char[][] map = new char[rows][columns];
		for (int i = 0; i < rows; i++) {
			String aString = sc.next();
			map[i] = aString.toCharArray();
		}
		int[][] step = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			Arrays.fill(step[i],Integer.MAX_VALUE);
		}
		LinkedList<Integer> xQueue = new LinkedList<Integer>();
		LinkedList<Integer> yQueue = new LinkedList<Integer>();
		outer_loop:
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if(map[i][j] == 'E') {
					step[i][j] = 0;
					xQueue.add(j);
					yQueue.add(i);
					break outer_loop;
				}
			}
		}
		while(!xQueue.isEmpty() && !yQueue.isEmpty()) {
			int curx = xQueue.poll();
			int cury = yQueue.poll();
			if(curx > 0 && step[cury][curx-1] > step[cury][curx]+1) {
				if(map[cury][curx-1] != 'T') {
					step[cury][curx-1] = step[cury][curx]+1;
					xQueue.add(curx-1);
					yQueue.add(cury);
				}
			}
			if(curx < columns-1 && step[cury][curx+1] > step[cury][curx]+1) {
				if(map[cury][curx+1] != 'T') {
					step[cury][curx+1] = step[cury][curx]+1;
					xQueue.add(curx+1);
					yQueue.add(cury);
				}
			}
			if(cury > 0 && step[cury-1][curx] > step[cury][curx]+1) {
				if(map[cury-1][curx] != 'T') {
					step[cury-1][curx] = step[cury][curx]+1;
					xQueue.add(curx);
					yQueue.add(cury-1);
				}
			}
			if(cury < rows-1 && step[cury+1][curx] > step[cury][curx]+1) {
				if(map[cury+1][curx] != 'T') {
					step[cury+1][curx] = step[cury][curx]+1;
					xQueue.add(curx);
					yQueue.add(cury+1);
				}
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if(map[i][j] == 'S') {
					requiredstep = step[i][j];
				}
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if(map[i][j] > 48 && map[i][j] < 58 && step[i][j] <=requiredstep) {
					battles+=map[i][j]-'0';
				}
			}
		}
		System.out.print(battles);
	}
}
