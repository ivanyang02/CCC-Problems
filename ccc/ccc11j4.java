package ccc;

public class ccc11j4 {
	public static void main(String[] args) {
		int[][] ground = new int[410][210];
		for (int i = 0; i < 3; i++) {
			ground[i][200] = 1;
			ground[4][203 + i] = 1;
			ground[2][205 + i] = 1;
			ground[2 + i][203] = 1;
			ground[2 + i][205] = 1;
			ground[2][200 + i] = 1;
			ground[3 + i][207] = 1;
			ground[4 + i][199] = 1;
		}
		for (int i = 0; i < 9; i++) {
			ground[6][199 + i] = 1;
		}
		int curr = 4;
		int curc = 199;
	}
}
