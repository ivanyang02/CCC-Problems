package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ccc04s3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[][] sheet = new String[10][9];
		int[][] newsheet = new int[10][9];
		for (int i = 0; i < 10; i++) {
			Arrays.fill(newsheet[i], -1);
		}
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				sheet[i][j] = st.nextToken();
				try {
					newsheet[i][j] = Integer.parseInt(sheet[i][j]);
				} catch (Exception e) {
				}
			}
		}
		boolean changed = true;
		while (changed == true) {
			changed = false;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 9; j++) {
					if (newsheet[i][j] == -1) {
						if (sheet[i][j].indexOf('+') == -1) {
							try {
								int row = sheet[i][j].charAt(0) - 'A';
								int column = sheet[i][j].charAt(1) - 49;
								if (newsheet[row][column] != -1) {
									newsheet[i][j] = newsheet[row][column];
									changed = true;
								}
							} catch (Exception e) {
							}
						} else {
							String[] coordinates = sheet[i][j].split("\\+");
							int sum = 0;
							boolean works = true;
							for (int k = 0; k < coordinates.length; k++) {
								int row = coordinates[k].charAt(0) - 'A';
								int column = coordinates[k].charAt(1) - 49;
								if (newsheet[row][column] == -1) {
									works = false;
									break;
								}
								sum += newsheet[row][column];
							}
							if (works == true) {
								newsheet[i][j] = sum;
								changed = true;
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				if (newsheet[i][j] == -1) {
					System.out.print("* ");
				} else {
					System.out.print(newsheet[i][j] + " ");
				}
			}
			System.out.println("");
		}
	}
}
