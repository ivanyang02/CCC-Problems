package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ccc18s3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int rows = Integer.parseInt(st.nextToken());
		int columns = Integer.parseInt(st.nextToken());
		char[][] maze = new char[rows][columns];
		for (int i = 0; i < rows; i++) {
			String a = br.readLine();
			maze[i] = a.toCharArray();
		}
		int[][] step = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			Arrays.fill(step[i], Integer.MAX_VALUE);
		}
		LinkedList<Integer> horizontalqueue = new LinkedList<Integer>();
		LinkedList<Integer> verticalqueue = new LinkedList<Integer>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (maze[i][j] == 'S') {
					step[i][j] = 0;
					horizontalqueue.add(j);
					verticalqueue.add(i);
				} else if (maze[i][j] == 'W') {
					step[i][j] = -1;
				} else if (maze[i][j] == 'C') {
					int a = i;
					int b = j;
					while (maze[a][b] != 'W') {
						if (maze[a][b] == '.' || maze[a][b] == 'S') {
							step[a][b] = -1;
						}
						a--;
					}
					a = i;
					b = j;
					while (maze[a][b] != 'W') {
						if (maze[a][b] == '.' || maze[a][b] == 'S') {
							step[a][b] = -1;

						}
						a++;
					}
					a = i;
					b = j;
					while (maze[a][b] != 'W') {
						if (maze[a][b] == '.' || maze[a][b] == 'S') {
							step[a][b] = -1;

						}
						b--;
					}
					a = i;
					b = j;
					while (maze[a][b] != 'W') {
						if (maze[a][b] == '.' || maze[a][b] == 'S') {
							step[a][b] = -1;

						}
						b++;
					}

				}
			}
		}
		while (!horizontalqueue.isEmpty() && !verticalqueue.isEmpty()) {
			int curcol = horizontalqueue.poll();
			int currow = verticalqueue.poll();
			if ((maze[currow][curcol] == '.' || maze[currow][curcol] == 'S') && step[currow][curcol] != -1) {
				if (step[currow - 1][curcol] != -1 && step[currow - 1][curcol] > step[currow][curcol] + 1) {
					step[currow - 1][curcol] = step[currow][curcol] + 1;
					horizontalqueue.add(curcol);
					verticalqueue.add(currow - 1);
				}
				if (step[currow + 1][curcol] != -1 && step[currow + 1][curcol] > step[currow][curcol] + 1) {
					step[currow + 1][curcol] = step[currow][curcol] + 1;
					horizontalqueue.add(curcol);
					verticalqueue.add(currow + 1);
				}
				if (step[currow][curcol - 1] != -1 && step[currow][curcol - 1] > step[currow][curcol] + 1) {
					step[currow][curcol - 1] = step[currow][curcol] + 1;
					horizontalqueue.add(curcol - 1);
					verticalqueue.add(currow);
				}
				if (step[currow][curcol + 1] != -1 && step[currow][curcol + 1] > step[currow][curcol] + 1) {
					step[currow][curcol + 1] = step[currow][curcol] + 1;
					horizontalqueue.add(curcol + 1);
					verticalqueue.add(currow);
				}
			} else if (maze[currow][curcol] == 'U') {
				if (step[currow - 1][curcol] != -1 && step[currow - 1][curcol] > step[currow][curcol]) {
					step[currow - 1][curcol] = step[currow][curcol];
					horizontalqueue.add(curcol);
					verticalqueue.add(currow - 1);
				}
			} else if (maze[currow][curcol] == 'D') {
				if (step[currow + 1][curcol] != -1 && step[currow + 1][curcol] > step[currow][curcol]) {
					step[currow + 1][curcol] = step[currow][curcol];
					horizontalqueue.add(curcol);
					verticalqueue.add(currow + 1);
				}
			} else if (maze[currow][curcol] == 'L') {
				if (step[currow][curcol - 1] != -1 && step[currow][curcol - 1] > step[currow][curcol]) {
					step[currow][curcol - 1] = step[currow][curcol];
					horizontalqueue.add(curcol - 1);
					verticalqueue.add(currow);
				}
			} else if (maze[currow][curcol] == 'R') {
				if (step[currow][curcol + 1] != -1 && step[currow][curcol + 1] > step[currow][curcol]) {
					step[currow][curcol + 1] = step[currow][curcol];
					horizontalqueue.add(curcol + 1);
					verticalqueue.add(currow);
				}
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (maze[i][j] == '.') {
					if (step[i][j] == Integer.MAX_VALUE) {
						System.out.println(-1);
					} else {
						System.out.println(step[i][j]);
					}
				}
			}
		}

	}
}
