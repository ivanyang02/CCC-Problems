package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class ccc15s1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		LinkedList<Integer> sum = new LinkedList<Integer>();
		int total = 0;
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a > 0) {
				sum.add(a);
				total += sum.getLast();
			} else {
				total -= sum.removeLast();
			}
		}
		System.out.println(total);
	}
}
