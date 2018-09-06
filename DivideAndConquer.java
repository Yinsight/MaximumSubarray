
public class DivideAndConquer {

	private static int maxSubarray(int[] a, int low, int high) {
		if (low == high) {
			return a[low];
		}
		
		int mid = (low + high) / 2;
		// find the maximum sum of left subarray (a[low]...a[mid])
		int leftSum = maxSubarray(a, low, mid);
		// find the maximum sum of right subarray (a[mid+1]...a[high])
		int rightSum = maxSubarray(a, mid + 1, high);
		// find the maximum sum of the subarray which must contains a[mid]
		int crossSum = maxCrossingSubarray(a, low, mid, high);
		
		// make Smax be the maximum of leftSum, rightSum and crossSum
		int Smax = leftSum;
		
		if (Smax < rightSum) {
			Smax = rightSum;
		}
		
		if (Smax < crossSum) {
			Smax = crossSum;
		}
		
		return Smax;
	}
	
	private static int maxCrossingSubarray(int[] a , int low, int mid, int high) {
		int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
		
		int sum = 0;
		// find the maximum sum of subarray in a[mid]->a[low]
		// the subarray start from a[mid]
		for (int i = mid; i >= low; i--) {
			sum += a[i];
			
			if (leftSum < sum) {
				leftSum = sum;
			}
		}
		
		sum = 0;
		// find the maximum sum of subarray in a[mid+1]->a[high]
		// the subarray should start from a[mid+1], if exists.
		// in other words, the sum of it should be greater than 0
		for (int j = mid + 1; j <= high; j++) {
			sum += a[j];
			if (rightSum < sum) {
				rightSum = sum;
			}
		}
		
		// (leftSum + rightSum) is the maximum sum of subarray in a[low]->a[high], which include a[mid]
		return leftSum + rightSum;
	}
	
	public static int maxSubarray(int[] a) {
		return maxSubarray(a, 0, a.length - 1);
	}
	
}
