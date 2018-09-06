
public class Kadane {

	public static int maxSubarray(int[] a) {
		int sum = 0, Smax = Integer.MIN_VALUE, len = a.length;
		
		for (int i = 0; i < len; i++) {
			// if the current sum is 0, than the subarray collected before 
			// can't be the prefix of the maximum subarray, so we clear the
			// previous subarray by making sum be 0
			if (sum < 0) {
				sum = 0;
			}
			
			sum += a[i];
			
			if (Smax < sum) {
				Smax = sum;
			}
			
		}
		
		return Smax;
	}
	
}
