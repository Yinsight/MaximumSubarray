import java.util.Random;
import java.util.Scanner;

public class MaximumSubarrayTest {

	public static void main(String[] args) {
		try (Scanner stdin = new Scanner(System.in)) {
			System.out.print("Please enter the size of the vector: ");
			int size = stdin.nextInt();
			int[] a = generateIntegerArray(size);

			long beginTime, endTime;

			beginTime = System.nanoTime();
			int sum1 = Kadane.maxSubarray(a);
			endTime = System.nanoTime();
			double time1 = getTime(beginTime, endTime);
			System.out.printf("%18s: The result is %d, the running time is %.2f ms\n",
					"Kadane", sum1, time1);
			
			beginTime = System.nanoTime();
			int sum2 = DivideAndConquer.maxSubarray(a);
			endTime = System.nanoTime();
			double time2 = getTime(beginTime, endTime);
			System.out.printf("%18s: The result is %d, the running time is %.2f ms\n", 
					"Divide and conquer", sum2, time2);
			
			beginTime = System.nanoTime();
			int sum3 = BruteForce.maxSubarray(a);
			endTime = System.nanoTime();
			double time3 = getTime(beginTime, endTime);
			System.out.printf("%18s: The result is %d, the running time is %.2f ms\n",
					"Brute force", sum3, time3);
		}

	}

	/**
	 * Generates an integer array of a given size randomly, including the sign.
	 * 
	 * @param size
	 *            the size of the array to be generated
	 * @return an integer array of the given size
	 */
	private static int[] generateIntegerArray(int size) {
		Random random = new Random();
		int[] array = new int[size];
		// ensure than the sum of the array would not overflow
		int bound = Integer.MAX_VALUE / size;

		for (int i = 0; i < size; i++) {
			array[i] = random.nextInt(bound);

			// assign the sign of numbers randomly
			if (random.nextBoolean()) {
				array[i] = -array[i];
			}
		}

		return array;
	}

	/**
	 * Gets the elapsed time, in milliseconds.
	 * 
	 * @param beginTime
	 *            the begin time, in nanoseconds
	 * @param endTime
	 *            the end time, in nanoseconds
	 * 
	 * @return the elapsed time, in milliseconds
	 */
	private static double getTime(long beginTime, long endTime) {
		return (endTime - beginTime) / 1E6;
	}

}
