import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

	public List<Time> mergeIntervals(List<Time> list) {
		Collections.sort(list, new TimeComparator());
		Time temp = list.get(0);
		List<Time> newList = new ArrayList<Time>();
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).getSt() <= temp.getEnd()) {
				temp = new Time(temp.getSt(), Math.max(list.get(i).getEnd(), temp.getEnd()));
			} else {
				newList.add(temp);
				temp = list.get(i);
			}
		}
		newList.add(temp);
		return newList;
	}
	public static int[][] merge(int[][] intervals) {
		// Base case: if intervals are empty, return an empty array
		if (intervals.length == 0) {
			return new int[0][0];
		}

		// Sort the intervals by the starting time
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		List<int[]> merged = new ArrayList<>();

		// Initialize the first interval to compare with
		int[] currentInterval = intervals[0];

		for (int i = 1; i < intervals.length; i++) {
			// If the current interval overlaps with the next one
			if (currentInterval[1] >= intervals[i][0]) {
				// Merge them by updating the end time
				currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
			} else {
				// No overlap, add the current interval to the result
				merged.add(currentInterval);
				// Move to the next interval
				currentInterval = intervals[i];
			}
		}

		// Add the last interval
		merged.add(currentInterval);

		// Convert List to int[][]
		return merged.toArray(new int[merged.size()][]);
	}
	public static void main(String[] args) {
		// {6,8}, {1,9}, {2,4}, {4,7}
		MergeIntervals mergeIntervals = new MergeIntervals();
		List<Time> list = new ArrayList<Time>();
		list.add(new Time(6, 8));
		list.add(new Time(1, 2));
		list.add(new Time(2, 4));
		list.add(new Time(4, 7));
		list.add(new Time(9, 12));
		List<Time> mergeList = mergeIntervals.mergeIntervals(list);
		System.out.println(mergeList);
	}

}
