package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ccc18s1 {
	public static void main(String[] Args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int villagenumber = Integer.parseInt(st.nextToken());
		double[] villages = new double[villagenumber];
		for (int i = 0; i < villagenumber; i++) {
			st = new StringTokenizer(br.readLine());
			villages[i] = Double.parseDouble(st.nextToken());
		}
		Arrays.sort(villages);
		double smallest = Double.MAX_VALUE;
		double neighbourhood;
		for (int i = 1; i < villagenumber - 1; i++) {
			neighbourhood = (villages[i+1] - villages[i - 1]) / 2;
			if (neighbourhood < smallest) {
				smallest = neighbourhood;
			}
		}
		System.out.printf("%.1f",smallest);
	}
}
