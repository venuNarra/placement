package dp;

public class CuttingRod {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
		System.out.println(maxprofit(arr, arr.length));
	}

	private static int maxprofit(int[] a, int n) {
		
		int[] value = new int[n + 1];
		value[0] = 0;
		for (int i = 1; i <= n; i++) {
			int maxValue = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				//given array index starts at 0.
				maxValue = Math.max(maxValue, a[j] + value[i - 1 - j]);
			}
			value[i] = maxValue;
		}
		return value[n];
	}
}
