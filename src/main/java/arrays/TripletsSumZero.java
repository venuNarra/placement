package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TripletsSumZero {
	@SuppressWarnings("unused")
	private static boolean findTriplets(int a[]) {
		boolean found = false;
		for (int i = 0; i < a.length - 2; i++)
			for (int j = i + 1; j < a.length - 1; j++)
				for (int k = j + 1; k < a.length; k++)
					if (a[i] + a[j] + a[k] == 0) {
						System.out.println(a[i] + " " + a[j] + " " + a[k]);
						found = true;
					}
		return found;
	}

	@SuppressWarnings("unused")
	private static void findTripletsSet(int a[]) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < a.length - 1; i++) {
			set = new HashSet<>();
			for (int j = i + 1; j < a.length; j++) {
				int x = -(a[i] + a[j]);
				if (set.contains(x)) {
					System.out.println(x + " " + a[i] + " " + a[j]);

				} else {
					set.add(a[j]);
				}
			}
		}

	}

	private static void findTripletsSort(int a[]) {
		Arrays.sort(a);
		
		for (int i = 0; i < a.length; i++) {
			int l = i + 1;
			int r = a.length - 1;
			while (l <= r) {
				if (a[i] + a[l] + a[r] == 0) {
					System.out.println(a[i] + " " + a[l] + " " + a[r]);
					l++;
					r--;
				} else if (a[i] + a[l] + a[r] < 0)
					l++;
				else
					r--;
			}
		}
	}

	public static void main(String[] args) {
		int a[] = { 0, -1, 2, -3, 1 };
		findTripletsSort(a);
	}
}
