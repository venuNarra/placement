package dp;

public class MaxSumSubArray {
	private static int maxSumSubArray(int a[]) {
		int max = a[0];
		int currMax = a[0];
		int start = 0;
		int end = 0;
		int s = 0;
		for (int i = 1; i < a.length; i++) {
			currMax = currMax + a[i];
			if (a[i] > currMax) {
				currMax = a[i];
				s = i;
			}
			if (max < currMax) {
				max = currMax;
				start = s;
				end = i;
			}

		}
		System.out.println(start + "  " + end);
		return max;

	}

	public static void main(String[] args) {
		int a[] = { -2, -3, 4, -1, -2, 6 };
		System.out.println(maxSumSubArray(a));
	}
}
