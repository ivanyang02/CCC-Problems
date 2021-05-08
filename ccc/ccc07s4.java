package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ccc07s4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int points = Integer.parseInt(br.readLine());
		LinkedList<Integer>[] map = new LinkedList[points + 1];
		for (int i = 0; i < points + 1; i++) {
			map[i] = new LinkedList<Integer>();
		}
		int[] paths = new int[points + 1];
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == 0 && b == 0) {
				break;
			} else {
				map[b].add(a);
			}
		}
		for (int i = points; i > 0; i--) {
			for (int j = 0; j < map[i].size(); j++) {
				if (i == points) {
					paths[map[i].get(j)]++;
				} else {
					if (paths[i] >= 1) {
						paths[map[i].get(j)] += paths[i];
					}
				}
			}
		}
		System.out.println(paths[1]);
	}
}
