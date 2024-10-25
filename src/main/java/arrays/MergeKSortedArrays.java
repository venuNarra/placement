package arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

	public static class ArrayContainer implements Comparable<ArrayContainer> {
		int[] array;
		int index;

		public ArrayContainer(int[] array, int index) {
			super();
			this.array = array;
			this.index = index;
		}

		public int[] getArray() {
			return array;
		}

		public int getIndex() {
			return index;
		}

		@Override
		public int compareTo(ArrayContainer o) {
			// TODO Auto-generated method stub
			return (this.array[this.index] - o.array[o.index]);
		}

	}

	public int[] mergeKsortedArrays(int[][] arr) {
		if(arr ==null || arr.length ==0 )
			return new int[0];

		//min heap using the priority queues
		PriorityQueue<ArrayContainer> pq = new PriorityQueue<>();
		int totalLength = 0;

		// Add the first element of each array to the minHeap
        for (int[] rowArray : arr) {
            pq.add(new ArrayContainer(rowArray, 0));
            totalLength += rowArray.length;
        }
		System.out.println(totalLength);
		int[] result = new int[totalLength];
		int i = 0;

		// process the elements from the priority queue
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
