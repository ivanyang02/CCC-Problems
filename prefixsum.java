
public class prefixsum {
	public static void main(String [] args) {
		int[] A = {1,2,3,4,5,6,7,8,9,10};
		int[] prefixsum = new int[10];
		for(int i = 0; i < 10; i++) {
			if(i == 0) {
				prefixsum[i] = A[i];
			}else {
				prefixsum[i] = A[i] + prefixsum[i-1];
			}
		}
		//output range sum from a[5] to a[9]
		System.out.println(prefixsum[9]-prefixsum[4]);
	}
}
