import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class magicalfunctions {
	static long a,b,c,d,e;

	public static long function(long N) {
		if (N == 0) {
			return e;
		}
		long ans = a * function(N / b)%1000000007 + c * function(N / d)%1000000007;
		return ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		c = Long.parseLong(st.nextToken());
		d = Long.parseLong(st.nextToken());
		e = Long.parseLong(st.nextToken());
		long N = Long.parseLong(st.nextToken());
		long ans = function(N) % (1000000007);
		System.out.println(ans);
	}
}
