package dp;

public class LIS {
	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60 };
		System.out.println(lis(arr));
	}

	private static int lis(int[] a) {

		int[] LIS = new int[a.length];
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			LIS[i] = 1;
		}
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j] && LIS[i] < (LIS[j] + 1))
					LIS[i] = LIS[j] + 1;
			}
		}
        for (int li : LIS)
            if (max < li)
                max = li;
		return max;
	}
}
