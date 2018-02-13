package arrays;

public class Median {
	static double getMedian(int a1[], int a2[], int n, int i, int j) {
		if (n < 0)
			return -1;
		if (n == 1)
			return (double)(a1[i] + a2[j]) / 2;
		if (n == 2)
			return (double)(Math.max(a1[i], a2[j]) + Math.min(a1[i + 1], a2[j + 1])) / 2;
		double m1 = median(a1, i, n);
		double m2 = median(a2, j, n);
	
		if (m1 < m2) {
			if (n % 2 == 0)
				return getMedian(a1, a2, n / 2 + 1, i + n / 2 - 1, j);
			else
				return getMedian(a1, a2, n / 2 + 1, i + n / 2, j);

		} else {
			if (n % 2 == 0)
				return getMedian(a1, a2, n / 2 + 1, i, j + n / 2 - 1);
			else
				return getMedian(a1, a2, n / 2 + 1, i, j + n / 2);
		}
		

	}

	static double median(int[] a, int i, int n) {

		if (n % 2 == 0)
			return (double) (a[i + n / 2] + a[i + n / 2 - 1]) / 2;
		else
			return (double) a[i + n / 2];
	}

	public static void main(String[] args) {
//		int a1[] = { 1, 2, 3, 4, 5, 6 };
//		int a2[] = { 3, 6, 9, 12, 15, 16 };
		int a1[] = {1, 2, 3, 6};
	    int a2[] = {4, 6, 8, 10};
		System.out.println(getMedian(a1, a2, a1.length, 0, 0));

	}
}
