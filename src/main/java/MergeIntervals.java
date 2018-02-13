import java.util.ArrayList;
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
