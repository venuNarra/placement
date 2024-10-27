package dp;

public class MaxSumSubArray {
	private static int maxSumSubArray(int[] a) {
		int maxSum = a[0];
		int currentSum = a[0];
		int start = 0;
		int end = 0;
		int tempStart = 0;
		for (int i = 1; i < a.length; i++) {
			currentSum = currentSum + a[i];
			if (a[i] > currentSum) {
				currentSum = a[i];
				tempStart = i;
			}
			if (currentSum > maxSum ) {
				maxSum = currentSum;
				start = tempStart;
				end = i;
			}

		}
		System.out.println(start + "  " + end);
		return maxSum;

	}

	public static void main(String[] args) {
		int[] a = { -2, -3, 4, -1, -2, 6 };
		System.out.println(maxSumSubArray(a));
	}
}
