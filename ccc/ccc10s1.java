package ccc;
import java.util.Arrays;
import java.util.Scanner;

public class ccc10s1 {

	public static class computer implements Comparable<computer> {
		String name;
		int r;
		int s;
		int d;
		int value;

		public computer(String name, int r, int s, int d) {
			this.name = name;
			this.r = r;
			this.s = s;
			this.d = d;
			this.value = 2 * r + 3 * s + d;
		}

		@Override
		public int compareTo(computer o) {
			if (this.value > o.value) {
				return 1;
			} else if (this.value < o.value) {
				return -1;
			} else if (this.name.compareTo(o.name) > 0) {
				return -1;
			} else if (this.name.compareTo(o.name) < 0) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n == 0) {
			return;
		}
		String name;
		int ram;
		int cpu;
		int disk;
		computer[] computers = new computer[n];
		for (int i = 0; i < n; i++) {
			name = sc.next();
			ram = sc.nextInt();
			cpu = sc.nextInt();
			disk = sc.nextInt();
			computers[i] = new computer(name, ram, cpu, disk);
		}
		Arrays.sort(computers);
			System.out.println(computers[n - 1].name);
		if (n > 1) {
			System.out.println(computers[n - 2].name);
		}
	}
}