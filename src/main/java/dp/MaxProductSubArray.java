package dp;

public class MaxProductSubArray {

	public static void main(String[] args) {
		int arr[] = { -2, -5, -3, 4, 2 };
		System.out.println(maxProductSubArray(arr));
	}

	private static int maxProductSubArray(int[] a) {

		int max = a[0];
		int min = a[0];
		int res = a[0];
		if (a.length == 0)
			return 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] < 0) {
				int temp = max;
				max = Math.max(Math.max(max, min * a[i]), a[i]);
				min = Math.min(Math.min(min, temp * a[i]), a[i]);
			} else {
				max = Math.max(Math.max(max, max * a[i]), a[i]);
				min = Math.min(Math.min(min, min * a[i]), a[i]);
			}
			System.out.println(max + " " + min);
		}
		res = Math.max(max, res);

		return res;
	}

}
