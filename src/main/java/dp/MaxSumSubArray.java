package dp;

import java.util.Stack;

public class MaxSumSubArray {
	private static int maxSumSubArray(int[] a) {
		// initialise the both maxSum and current as first element of the array
		int maxSum = a[0];
		int currentSum = a[0];
		int start = 0;
		int end = 0;
		int tempStart = 0;

		// Modified version of cadence Algorithm
		// process on the array from 2nd element onwards
		for (int i = 1; i < a.length; i++) {
			currentSum = currentSum + a[i];
			if (a[i] > currentSum) {     // compare the current sum & a[i] and capture the start index
				currentSum = a[i];
				tempStart = i;
			}
			if (currentSum > maxSum ) {
				maxSum = currentSum;
				start = tempStart;
				end = i;         // capture the end index
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
