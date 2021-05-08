import java.util.Arrays;

public class arraytester {
	static int[][] square = { { 1, 2, 3, 4 }, { 2, 1, 4, 3 }, { 3, 4, 1, 2 }, { 4, 3, 2, 1 } };
	static boolean is = islatin(square);

	public static int[] getcolumn(int[][] arr2d, int c) {
		int[] column = new int[arr2d.length];
		for (int i = 0; i < arr2d.length; i++) {
			column[i] = arr2d[i][c];
		}
		return column;
	}

	public static boolean hasallvalues(int[] arr1, int[] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] != arr2[j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean containsduplicates(int[] arr) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static boolean islatin(int[][] square) {
		int[][] arr = new int[square.length][square.length];
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square.length; j++) {
				arr[i][j] = square[i][j];
			}
		}
		int[][] arr2 = new int[square.length][square.length];
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square.length; j++) {
				arr2[i][j] = square[j][i];
			}
		}
		Arrays.sort(arr[0]);
		for (int i = 0; i < arr[0].length - 1; i++) {
			if (arr[0][i] == arr[0][i + 1]) {
				return false;
			}
		}
		for (int i = 1; i < arr.length; i++) {
			Arrays.sort(arr[i]);
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] != arr[0][j]) {
					return false;
				}
			}
		}
		for (int i = 0; i < arr2.length; i++) {
			Arrays.sort(arr2[i]);
			for (int j = 0; j < arr.length; j++) {
				if (arr2[i][j] != arr[0][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(is);
	}
}