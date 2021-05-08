package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ccc05s4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int trees = Integer.parseInt(st.nextToken());
		for (int qw = 0; qw < trees; qw++) {
			st = new StringTokenizer(br.readLine());
			int paths = Integer.parseInt(st.nextToken());
			LinkedList<String> names = new LinkedList<String>();
			String[] pathnames = new String[paths];
			for (int i = 0; i < paths; i++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				pathnames[i] = name;
				boolean unique = true;
				for (int j = 0; j < i; j++) {
					if (pathnames[i].equals(pathnames[j]) && i != j) {
						unique = false;
						break;
					}
				}
				if (unique == true) {
					names.add(name);
				}
			}

			boolean[][] tree = new boolean[names.size()][names.size()];
			for (int i = 0; i < paths; i += 2) {
				int bv = -1;
				int ev = -1;
				for (int j = 0; j < names.size(); j++) {
					if (pathnames[i].equals(names.get(j))) {
						bv = j;
					}
					if (pathnames[i + 1].equals(names.get(j))) {
						ev = j;
					}
				}
				tree[bv][ev] = true;
				tree[ev][bv] = true;
			}
			int originaltime = 0;
			int pathnumber = 0;
			int queuestart = 0;
			for (int i = 0; i < names.size(); i++) {
				pathnumber = 0;
				for (int j = 0; j < names.size(); j++) {
					if (tree[i][j] == true) {
						pathnumber++;
						originaltime++;
					}
				}
			}
			for(int i = 0; i < names.size(); i++) {
				if(pathnames[paths-1].equals(names.get(i))) {
					queuestart = i;
				}
			}
			LinkedList<Integer> queue = new LinkedList<Integer>();
			int[] step = new int[names.size()];
			Arrays.fill(step, Integer.MAX_VALUE);
			queue.add(queuestart);
			step[queuestart] = 0;
			while (!queue.isEmpty()) {
				int curv = queue.poll();
				for (int i = 0; i < step.length; i++) {
					if (tree[curv][i] == true && step[i] > step[curv] + 1) {
						step[i] = step[curv] + 1;
						queue.add(i);
					}
				}
			}
			int largest = 0;
			for (int i = 0; i < step.length; i++) {
				if (step[i] > largest) {
					largest = step[i];
				}
			}
			int smallertime = largest * 2;
			int timesaved = originaltime - smallertime;
			timesaved *= 10;
			System.out.println(timesaved);
		}
	}
}
