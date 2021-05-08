import java.util.LinkedList;
import java.util.Scanner;

public class kingspath {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int[][] step = new int[100][100];

		for (int row = 0; row < 100; row++) {
			for (int col = 0; col < 100; col++) {
				step[row][col] = -1;
			}
		}

		int BR = sc.nextInt();
		int BC = sc.nextInt();
		int ER = sc.nextInt();
		int EC = sc.nextInt();

		int times = sc.nextInt();
		for (int i = 0; i < times; i++) {
			int r = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			for (int j = a; j <= b; j++) {
				step[r][j] = Integer.MAX_VALUE;
			}
		}

		LinkedList<Integer> rowQ = new LinkedList<Integer>();
		LinkedList<Integer> colQ = new LinkedList<Integer>();

		rowQ.add(BR);
		colQ.add(BC);
		step[BR][BC] = 0;

		while (!rowQ.isEmpty()) {
			int R = rowQ.poll();
			int C = colQ.poll();
			if (R > 0 && R < 99 && C > 0 && C < 99) {
				if (step[R - 1][C - 1] > step[R][C] + 1) {
					step[R - 1][C - 1] = step[R][C] + 1;
					rowQ.add(R - 1);
					colQ.add(C - 1);
				}
				if (step[R - 1][C] > step[R][C] + 1) {
					step[R - 1][C] = step[R][C] + 1;
					rowQ.add(R - 1);
					colQ.add(C);
				}
				if (step[R - 1][C + 1] > step[R][C] + 1) {
					step[R - 1][C + 1] = step[R][C] + 1;
					rowQ.add(R - 1);
					colQ.add(C + 1);
				}
				if (step[R + 1][C - 1] > step[R][C] + 1) {
					step[R + 1][C - 1] = step[R][C] + 1;
					rowQ.add(R + 1);
					colQ.add(C - 1);
				}
				if (step[R + 1][C] > step[R][C] + 1) {
					step[R + 1][C] = step[R][C] + 1;
					rowQ.add(R + 1);
					colQ.add(C);
				}
				if (step[R + 1][C + 1] > step[R][C] + 1) {
					step[R + 1][C + 1] = step[R][C] + 1;
					rowQ.add(R + 1);
					colQ.add(C + 1);
				}
				if (step[R][C - 1] > step[R][C] + 1) {
					step[R][C - 1] = step[R][C] + 1;
					rowQ.add(R);
					colQ.add(C - 1);
				}
				if (step[R][C + 1] > step[R][C] + 1) {
					step[R][C + 1] = step[R][C] + 1;
					rowQ.add(R);
					colQ.add(C + 1);
				}
			}
		}
		if (step[ER][EC] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(step[ER][EC]);
		}
	}
}