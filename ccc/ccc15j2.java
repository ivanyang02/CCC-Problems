package ccc;

import java.util.Scanner;

public class ccc15j2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine();
		String happy = sentence.replace(":-)", "");
		String sad = sentence.replace(":-(", "");
		if (sentence.length() * 2 - happy.length() - sad.length() == 0) {
			System.out.println("none");
		} else if (sentence.length() - happy.length() > sentence.length() - sad.length()) {
			System.out.println("happy");
		} else if (sentence.length() - happy.length() < sentence.length() - sad.length()) {
			System.out.println("sad");
		} else if (sentence.length() - happy.length() == sentence.length() - sad.length()) {
			System.out.println("unsure");
		}
	}
}
