package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TripletsSumZero {

	// Brute force approach
	private static void findTriplets(int[] a) {
		for (int i = 0; i < a.length - 2; i++)
			for (int j = i + 1; j < a.length - 1; j++)
				for (int k = j + 1; k < a.length; k++)
					if (a[i] + a[j] + a[k] == 0) {
						System.out.println(a[i] + " " + a[j] + " " + a[k]);
					}
	}

	// Using set instead of 3rd loop
	private static void findTripletsSet(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			Set<Integer> set = new HashSet<>(); // for every i we are creating a new set.
			for (int j = i + 1; j < a.length; j++) {
				int x = -(a[i] + a[j]);
				if (set.contains(x)) {
					System.out.println(x + " " + a[i] + " " + a[j]);

				} else {
					set.add(a[j]); // The elements tracked with the j indexed elements visited so far.
				}
			}
		}

	}

	// sorting & using the 2 pointers technique
	private static void findTripletsSort(int[] a) {
		Arrays.sort(a);
		
		for (int i = 0; i < a.length - 1; i++) {
			int l = i + 1;
			int r = a.length - 1;
			while (l < r) {
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
		int[] a = { 0, -1, 2, -3, 1 };
		int[] b ={-1, 0, 1, 2, -1, -4};
		findTriplets(a);
		System.out.println( "-------");
		findTripletsSet(a);
		System.out.println( "-------");
		findTripletsSort(a);
		System.out.println( "-------");
		findTriplets(b);
		System.out.println( "-------");
		findTripletsSet(b);
		System.out.println( "-------");
		findTripletsSort(b);
	}
}
