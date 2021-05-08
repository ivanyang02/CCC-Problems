package ccc;

import java.util.LinkedList;
import java.util.Scanner;

public class ccc19s3 {

	static LinkedList<node> missing = new LinkedList<node>();
	static LinkedList<node> solved = new LinkedList<node>();

	public static class node {
		int row;
		int col;
		int val;

		public node(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
	}

	public static int[][] solve(int[][] square) {
		boolean action;
		int counter = 0;
		while (counter < missing.size()) {
			action = false;
			node curnode = missing.poll();
			int noderow = curnode.row;
			int nodecol = curnode.col;
			if (noderow == 0 || noderow == 2) {
				if (square[1][nodecol] != 1 << 20 && square[2 - noderow][nodecol] != 1 << 20) {
					square[noderow][nodecol] = square[1][nodecol] * 2 - square[2 - noderow][nodecol];
					solved.add(new node(noderow, nodecol, square[noderow][nodecol]));
					action = true;
				}
			} else if (noderow == 1) {
				if (square[0][nodecol] != 1 << 20 && square[2][nodecol] != 1 << 20) {
					square[noderow][nodecol] = (square[0][nodecol] + square[2][nodecol]) / 2;
					solved.add(new node(noderow, nodecol, square[noderow][nodecol]));
					action = true;
				}
			}
			if (nodecol == 0 || nodecol == 2) {
				if (square[noderow][1] != 1 << 20 && square[noderow][2 - nodecol] != 1 << 20) {
					square[noderow][nodecol] = square[noderow][1] * 2 - square[noderow][2 - nodecol];
					solved.add(new node(noderow, nodecol, square[noderow][nodecol]));
					action = true;
				}
			} else if (nodecol == 1) {
				if (square[noderow][0] != 1 << 20 && square[noderow][2] != 1 << 20) {
					square[noderow][nodecol] = (square[noderow][0] + square[noderow][2]) / 2;
					solved.add(new node(noderow, nodecol, square[noderow][nodecol]));
					action = true;
				}
			}
			if (action == false) {
				counter++;
				missing.add(curnode);
			} else {
				counter = 0;
			}
		}
		return square;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] square = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				String a = sc.next();
				if (!a.equals("X")) {
					square[i][j] = Integer.parseInt(a);
					solved.add(new node(i, j, Integer.parseInt(a)));
				} else {
					square[i][j] = 1 << 20;
					missing.add(new node(i, j, 1 << 20));
				}
			}
		}
		for (int q = 0; q < 1; q++) {
			if (solved.size() == 0) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						square[i][j] = 0;

					}
				}
				break;
			} else if (solved.size() == 1) {
				int ans = solved.poll().val;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						square[i][j] = ans;
					}
				}
				break;
			} else {
				square = solve(square);
				if (solved.size() == 2) {
					int currow1 = solved.get(0).row;
					int currow2 = solved.get(1).row;
					for (int i = 0; i < 3; i++) {
						square[currow1][i] = solved.peek().val;
						square[currow2][i] = solved.get(1).val;
					}
					square = solve(square);
					break;
				} else if (solved.size() == 3) {
					if (solved.peek().row == solved.get(1).row && solved.get(1).row == solved.get(2).row
							&& solved.peek().row == solved.get(2).row) {
						for (int i = 0; i < 3; i++) {
							square[i][solved.peek().col] = solved.peek().val;
							square[i][solved.get(1).col] = solved.get(1).val;
							square[i][solved.get(2).col] = solved.get(2).val;
						}
					} else if (solved.peek().col == solved.get(1).col && solved.get(1).col == solved.get(2).col
							&& solved.peek().col == solved.get(2).col) {
						for (int i = 0; i < 3; i++) {
							square[solved.peek().row][i] = solved.peek().val;
							square[solved.get(1).row][i] = solved.get(1).val;
							square[solved.get(2).row][i] = solved.get(2).val;
						}
					} else {
						int currow1 = solved.peek().row;
						int currow2 = solved.get(1).row;
						int currow3 = solved.get(2).row;
						for (int i = 0; i < 3; i++) {
							square[currow1][i] = solved.peek().val;
							square[currow2][i] = solved.get(1).val;
							square[currow3][i] = solved.get(2).val;
						}
					}
					square = solve(square);
				} else if (solved.size() == 5) {
					if (square[0][0] != 1 << 20 && square[0][1] != 1 << 20 && square[0][2] != 1 << 20) {
						if (square[1][0] != 1 << 20 && square[2][0] != 1 << 20) {
							square[1][1] = Math.max(square[0][2], square[2][0]);
						} else if (square[1][1] != 1 << 20 && square[2][1] != 1 << 20) {
							square[1][0] = square[0][0];
						} else {
							square[1][1] = (square[1][2] + square[0][1]) / 2;
						}
					} else if (square[1][0] != 1 << 20 && square[1][1] != 1 << 20 && square[1][2] != 1 << 20) {
						if (square[0][0] != 1 << 20 && square[2][0] != 1 << 20) {
							square[0][1] = square[0][0];
						} else if (square[0][1] != 1 << 20 && square[2][1] != 1 << 20) {
							square[0][0] = Math.min(square[1][0], square[0][1]);
						} else {
							square[0][1] = Math.min(square[1][0], square[0][2]);
						}
					} else {
						if (square[0][0] != 1 << 20 && square[1][0] != 1 << 20) {
							square[1][1] = (square[1][0] + square[2][1]) / 2;
						} else if (square[0][1] != 1 << 20 && square[1][1] != 1 << 20) {
							square[0][0] = Math.min(square[0][1], square[2][0]);
						} else {
							square[0][0] = Math.min(square[2][0], square[0][2]);
						}
					}
					square = solve(square);
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (square[i][j] != 1 << 20) {
					System.out.print(square[i][j] + " ");
				} else {
					System.out.print("X ");
				}
			}
			System.out.println("");
		}
	}
}
