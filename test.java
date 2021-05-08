
public class test {
	public static void main(String[] args) {
		int n = 10;
		for(int i = 0; i < n; i++) {
			System.out.println(i);
			if(i == 5) {
				n-=4;
			}
		}
	}
}
