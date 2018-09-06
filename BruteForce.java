public class BruteForce {

	public static int maxSubarray(int[] a) {
		
		int Smax = Integer.MIN_VALUE;
		int sum = 0, len = a.length;
		
		for (int i = 0; i < len; i++) {
			sum = 0;
			
			for (int j = i; j < len; j++) {
				sum += a[j];  // get the sum of a[i]->a[j] (contiguous)
				
				// if the sum is greater than Smax, than update Smax
				if (sum > Smax) {
					Smax = sum;
				}
			}
		}
		
		return Smax;
	}
	
}
