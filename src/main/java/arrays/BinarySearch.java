package arrays;

public class BinarySearch {

	static int binarySearch(int[] a, int n) {
		if(a == null || a.length ==0)
			return -1;
		int l = 0, r = a.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (a[mid] == n)
				return mid;
			else if (a[mid] < n)
				l = mid + 1;
			else
				r = mid - 1;
		}
		return -1;

	}

	static int binarySearchRecur(int[] a, int l, int r, int n) {
		if (l > r)
			return -1;
		int mid = l + (r - l) / 2;
		if (a[mid] == n)
			return mid;
		else if (a[mid] < n)
			return binarySearchRecur(a, mid + 1, r, n);
		else
			return binarySearchRecur(a, l, mid - 1, n);
	}

	public static void main(String[] args) {
		int[] a = { 2, 6, 13, 16, 21, 34, 56 };
		System.out.println(binarySearchRecur(a, 0, a.length, 3));
	}

}
