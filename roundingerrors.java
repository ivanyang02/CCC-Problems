import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class roundingerrors {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int times = Integer.parseInt(br.readLine());
		int up = 0;
		int down = 0;
		for(int i = 0; i < times; i++) {
			double number = Double.parseDouble(br.readLine());
			number-=(double)(int)number;
			if(number >= 0.5) {
				up++;
			}else {
				down++;
			}
		}
		System.out.println(up);
		System.out.println(down);
	}
}
