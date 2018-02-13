package arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

	public class ArrayContainer implements Comparable<ArrayContainer> {
		int array[];
		int index;

		public ArrayContainer(int[] array, int index) {
			super();
			this.array = array;
			this.index = index;
		}

		public int[] getArray() {
			return array;
		}

		public void setArray(int[] array) {
			this.array = array;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		@Override
		public int compareTo(ArrayContainer o) {
			// TODO Auto-generated method stub
			return (this.array[this.index] - o.array[o.index]);
		}

	}

	public int[] mergeKsortedArrays(int[][] arr) {
		PriorityQueue<ArrayContainer> pq = new PriorityQueue<ArrayContainer>();
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			pq.add(new ArrayContainer(arr[i], 0));
			total += arr[i].length;
		}
		System.out.println(total);
		int[] result = new int[total];
		int i = 0;
		while (!pq.isEmpty()) {
			ArrayContainer ac = pq.poll();
			int index = ac.getIndex();
			System.out.println(ac.getArray().length);
			result[i++] = ac.getArray()[index];
			if (index < ac.getArray().length-1)
				pq.add(new ArrayContainer(ac.getArray(), index + 1));
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5 ,7};
		int[] arr2 = { 2, 4, 6 };
		int[] arr3 = { 0, 9, 10, 11 };
		MergeKSortedArrays test = new MergeKSortedArrays();
		int[] result = test.mergeKsortedArrays(new int[][] { arr1, arr2, arr3 });
		System.out.println(Arrays.toString(result));
	}
}
