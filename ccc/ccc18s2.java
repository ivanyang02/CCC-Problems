package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ccc18s2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int dimension = Integer.parseInt(st.nextToken());
		int[][] records = new int[dimension][dimension];
		for (int i = 0; i < dimension; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < dimension; j++) {
				records[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if (records[0][0] < records[0][records.length - 1] && records[0][0] < records[records.length - 1][0]
				&& records[records.length - 1][records.length - 1] > records[records.length - 1][0]
				&& records[records.length - 1][records.length - 1] > records[0][records.length - 1]) {
			for(int i = 0; i < dimension; i++) {
				for(int j = 0; j < dimension; j++) {
					System.out.print(records[i][j]+" ");
				}
				System.out.println("");
			}
		}
		else if (records[0][0] > records[0][records.length - 1] && records[records.length - 1][records.length - 1] > records[0][records.length - 1]
				&& records[0][0] < records[records.length - 1][0]
				&& records[records.length - 1][records.length - 1] < records[records.length - 1][0]) {
			for(int i = dimension-1; i >= 0; i--) {
				for(int j = 0; j < dimension; j++) {
					System.out.print(records[j][i]+" ");
				}
				System.out.println("");
			}
		}
		else if (records[records.length - 1][records.length - 1] < records[0][records.length - 1] && records[records.length - 1][records.length - 1] < records[records.length - 1][0]
				&& records[0][0] > records[records.length - 1][0]
				&& records[0][0] > records[0][records.length - 1]) {
			for(int i = dimension-1; i >= 0; i--) {
				for(int j = dimension-1; j >= 0; j--) {
					System.out.print(records[i][j]+" ");
				}
				System.out.println("");
			}
		}
		else if (records[0][0] < records[0][records.length - 1] && records[records.length - 1][records.length - 1] < records[0][records.length - 1]
				&& records[0][0] > records[records.length - 1][0]
				&& records[records.length - 1][records.length - 1] > records[records.length - 1][0]) {
			for(int i = 0; i < dimension; i++) {
				for(int j = dimension-1; j >= 0; j--) {
					System.out.print(records[j][i]+" ");
				}
				System.out.println("");
			}
		}
	}
}
