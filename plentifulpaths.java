import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class plentifulpaths {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] map = new int[m][n];
		int[][] step = new int[m][n];
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		while (r != 0 || c != 0) {
			map[m - r][c - 1] = 1;
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
		}
		for (int i = m - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				try {
					step[i][j] = Math.max(step[i + 1][j], step[i][j - 1]);
				} catch (Exception e) {

				}
				if (map[i][j] != 0) {
					step[i][j]++;
				}
			}
		}
		System.out.println(step[0][n - 1] + 1);
	}
}
