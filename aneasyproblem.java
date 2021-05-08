
public class aneasyproblem {
	static long get_power(int X, int Y, int M){
		long answer = 1;
		for (long base = X, group = 1; group <= Y; group*=2, base = ((long)base*base) % M){
			if ((group & Y) > 0){
				answer = (long) answer * (base) % M;
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		System.out.println(get_power(1000000000,1000000000-1,1000000007));
	}
}
