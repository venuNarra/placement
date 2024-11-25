package dp;

import java.util.Arrays;
//subsequence
public class LIS {
	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60 };
		System.out.println(lis(arr));
	}

	private static int lis(int[] a) {

		int[] LIS = new int[a.length];
		int maxLength = 1;

		// Each element initialized with 1 as each element is a subsequence of length 1
		Arrays.fill(LIS, 1);

		// Build the LIS array
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j] && LIS[i] < (LIS[j] + 1))
					LIS[i] = LIS[j] + 1; // math.MAX( LIS[i], LIS[j]+1)
			}
			// Track the maximum length value of LIS during the loop itself
			maxLength = Math.max(maxLength, LIS[i]);
		}
		return maxLength;
	}
}
