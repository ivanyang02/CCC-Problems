package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ccc11s4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int received = 0;
		int[] amounts = new int[8];
		int[] required = new int[8];
		for (int i = 0; i < 8; i++) {
			amounts[i] = Integer.parseInt(st1.nextToken());
			required[i] = Integer.parseInt(st2.nextToken());
		}
		while(amounts[0] > 0) {
			if(required[0] > 0) {
				amounts[0]--;
				required[0]--;
				received++;
			}else {
				break;
			}
		}
		while(amounts[0] > 0) {
			if(required[2] > 0) {
				amounts[0]--;
				required[2]--;
				received++;
			}else {
				break;
			}
		}
		while(amounts[0] > 0) {
			if(required[4] > 0) {
				amounts[0]--;
				required[4]--;
				received++;
			}else {
				break;
			}
		}
		while(amounts[0] > 0) {
			if(required[6] > 0) {
				amounts[0]--;
				required[6]--;
				received++;
			}else {
				break;
			}
		}
		while(amounts[0] > 0) {
			if(required[1] > 0) {
				amounts[0]--;
				required[0]--;
				received++;
			}else {
				break;
			}
		}
		while(amounts[0] > 0) {
			if(required[3] > 0) {
				amounts[0]--;
				required[3]--;
				received++;
			}else {
				break;
			}
		}
		while(amounts[0] > 0) {
			if(required[5] > 0) {
				amounts[0]--;
				required[5]--;
				received++;
			}else {
				break;
			}
		}
		while(amounts[0] > 0) {
			if(required[7] > 0) {
				amounts[0]--;
				required[7]--;
				received++;
			}else {
				break;
			}
		}
		while(amounts[2] > 0) {
			if(required[2] > 0) {
				amounts[2]--;
				required[2]--;
				received++;
			}else {
				break;
			}
		}
		while(amounts[2] > 0) {
			if(required[3] > 0) {
				amounts[2]--;
				required[3]--;
				received++;
			}else {
				break;
			}
		}
		while(amounts[2] > 0) {
			if(required[6] > 0) {
				amounts[2]--;
				required[6]--;
				received++;
			}else {
				break;
			}
		}
		while(amounts[4] > 0) {
			if(required[4] > 0) {
				amounts[4]--;
				required[4]--;
				received++;
			}else {
				break;
			}
		}
		while(amounts[4] > 0) {
			if(required[5] > 0) {
				amounts[4]--;
				required[5]--;
				received++;
			}else {
				break;
			}
		}
		while(amounts[4] > 0) {
			if(required[6] > 0) {
				amounts[4]--;
				required[6]--;
				received++;
			}else {
				break;
			}
		}
		while(amounts[1] > 0) {
			if(required[1] > 0) {
				amounts[1]--;
				required[1]--;
				received++;
			}else {
				break;
			}
		}
		while(amounts[1] > 0) {
			if(required[3] > 0) {
				amounts[1]--;
				required[3]--;
				received++;
			}else {
				break;
			}
		}
		while(amounts[1] > 0) {
			if(required[5] > 0) {
				amounts[1]--;
				required[5]--;
				received++;
			}else {
				break;
			}
		}
		while(amounts[1] > 0) {
			if(required[7] > 0) {
				amounts[1]--;
				required[7]--;
				received++;
			}else {
				break;
			}
		}
		while(amounts[3] > 0) {
			if(required[3] > 0) {
				amounts[3]--;
				required[3]--;
				received++;
			}else {
				break;
			}
		}
		while(amounts[3] > 0) {
			if(required[7] > 0) {
				amounts[3]--;
				required[7]--;
				received++;
			}else {
				break;
			}
		}
		while(amounts[5] > 0) {
			if(required[5] > 0) {
				amounts[5]--;
				required[5]--;
				received++;
			}else {
				break;
			}
		}
		while(amounts[5] > 0) {
			if(required[7] > 0) {
				amounts[5]--;
				required[7]--;
				received++;
			}else {
				break;
			}
		}
		while(amounts[6] > 0) {
			if(required[6] > 0) {
				amounts[6]--;
				required[6]--;
				received++;
			}else {
				break;
			}
		}
		while(amounts[6] > 0) {
			if(required[7] > 0) {
				amounts[6]--;
				required[7]--;
				received++;
			}else {
				break;
			}
		}
		while(amounts[7] > 0) {
			if(required[7] > 0) {
				amounts[7]--;
				required[7]--;
				received++;
			}else {
				break;
			}
		}
		System.out.println(received);
	}
}
