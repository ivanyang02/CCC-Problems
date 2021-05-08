import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class strayingfromgoddp {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dimensions = Integer.parseInt(br.readLine());
		int[][] step = new int[dimensions][dimensions];
		for (int i = 0; i < dimensions; i++) {
			String s = br.readLine();
			for (int j = 0; j < dimensions; j++) {
				if (s.charAt(j) == '.') {
					step[i][j] = 1 << 30;
				} else {
					step[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		step[0][0] = 0;
		for (int i = 0; i < dimensions; i++) {
			for (int j = 0; j < dimensions; j++) {
				if (step[i][j] <= 1 << 30) {
					if (i == 0) {
						if (j != 0 && step[i][j - 1] < 1 << 30 && step[i][j] > step[i][j - 1] + 1) {
							step[i][j] = step[i][j - 1] + 1;
						}
					} else if (j == 0) {
						if (i != 0 && step[i - 1][j] < 1 << 30 && step[i][j] > step[i - 1][j] + 1) {
							step[i][j] = step[i - 1][j] + 1;
						}
					} else if (step[i - 1][j] < 1 << 30 && step[i][j - 1] > 1 << 30
							&& step[i][j] > step[i - 1][j] + 1) {
						step[i][j] = step[i - 1][j] + 1;
					} else if (step[i - 1][j] > 1 << 30 && step[i][j - 1] < 1 << 30
							&& step[i][j] > step[i][j - 1] + 1) {
						step[i][j] = step[i][j - 1] + 1;
					} else if (step[i - 1][j] < 1 << 30 && step[i][j - 1] < 1 << 30) {
						if (step[i][j] > step[i - 1][j] + 1 && step[i][j] <= step[i][j - 1] + 1) {
							step[i][j] = step[i - 1][j] + 1;
						} else if (step[i][j] > step[i][j - 1] + 1 && step[i][j] <= step[i - 1][j] + 1) {
							step[i][j] = step[i][j - 1] + 1;
						} else if (step[i][j] > step[i - 1][j] + 1 && step[i][j] > step[i][j - 1] + 1) {
							step[i][j] = Math.min(step[i - 1][j], step[i][j - 1]) + 1;
						}
					}
				}
			}
			for (int j = dimensions - 1; j >= 0; j--) {
				if (step[i][j] <= 1 << 30) {
					if (i == 0) {
						if (j != dimensions - 1 && step[i][j + 1] < 1 << 30 && step[i][j] > step[i][j + 1] + 1) {
							step[i][j] = step[i][j + 1] + 1;
						}
					} else if (j == dimensions - 1) {
						if (i != 0 && step[i - 1][j] < 1 << 30 && step[i][j] > step[i - 1][j] + 1) {
							step[i][j] = step[i - 1][j] + 1;
						}
					} else if (step[i - 1][j] < 1 << 30 && step[i][j + 1] > 1 << 30
							&& step[i][j] > step[i - 1][j] + 1) {
						step[i][j] = step[i - 1][j] + 1;
					} else if (step[i - 1][j] > 1 << 30 && step[i][j + 1] < 1 << 30
							&& step[i][j] > step[i][j - 1] + 1) {
						step[i][j] = step[i][j - 1] + 1;
					} else if (step[i - 1][j] < 1 << 30 && step[i][j + 1] < 1 << 30) {
						if (step[i][j] > step[i - 1][j] + 1 && step[i][j] <= step[i][j + 1] + 1) {
							step[i][j] = step[i - 1][j] + 1;
						} else if (step[i][j] > step[i][j + 1] + 1 && step[i][j] <= step[i - 1][j] + 1) {
							step[i][j] = step[i][j + 1] + 1;
						} else if (step[i][j] > step[i - 1][j] + 1 && step[i][j] > step[i][j + 1] + 1) {
							step[i][j] = Math.min(step[i - 1][j], step[i][j + 1]) + 1;
						}
					}
				}
			}
		}
		for (int i = 0; i < dimensions; i++) {
			for (int j = 0; j < dimensions; j++) {
				if (step[i][j] >= 1 << 30) {
					System.out.print("##");
				}
				System.out.print(step[i][j]);
			}
			System.out.println("");
		}
	}

}
