import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class gridoutput {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[][] grid = { { "1", "2", "3", "A2", "A3" }, { "B2", "4", "5", "6", "7" },
				{ "C5", "8", "9", "10", "11" } };
		String gridquery = br.readLine();
		int row = gridquery.charAt(0) - 'A';
		int col = gridquery.charAt(1) - '1';
		while (true) {
			try {
				System.out.println(Integer.parseInt(grid[row][col]));
				break;
			} catch (Exception e) {
				row = grid[row][col].charAt(0) - 'A';
				col = grid[row][col].charAt(1) - '1';
			}
		}
	}
}
