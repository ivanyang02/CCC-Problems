package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ccc15s2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int jerseys = Integer.parseInt(br.readLine());
		int athletes = Integer.parseInt(br.readLine());
		char[] jerseylist = new char[jerseys];
		for (int i = 0; i < jerseys; i++) {
			String s = br.readLine();
			jerseylist[i] = s.charAt(0);
		}
		int count = 0;
		for (int i = 0; i < athletes; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char size = st.nextToken().charAt(0);
			int num = Integer.parseInt(st.nextToken()) - 1;
			if (jerseylist[num] != 'q') {
				if (size == 'S') {
					jerseylist[num] = 'q';
					count++;
				} else if (size == 'M') {
					if (jerseylist[num] != 'S') {
						jerseylist[num] = 'q';
						count++;
					}
				} else {
					if (jerseylist[num] == 'L') {
						jerseylist[num] = 'q';
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}