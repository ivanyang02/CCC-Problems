package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ccc12s5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int trapcount = Integer.parseInt(br.readLine());
		int[][] map = new int[r][c];
		map[0][0] = 1;
		for (int i = 0; i < trapcount; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken()) - 1;
			int c1 = Integer.parseInt(st.nextToken()) - 1;
			map[r1][c1] = -1;
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] != -1) {
					if (i > 0 && map[i - 1][j] != -1) {
						map[i][j] += map[i - 1][j];
					}
					if (j > 0 && map[i][j - 1] != -1) {
						map[i][j] += map[i][j - 1];
					}
				}
			}
		}
		System.out.println(map[r - 1][c - 1]);
	}
}
