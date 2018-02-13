import java.util.Comparator;

public class TimeComparator implements Comparator<Time>{

	@Override
	public int compare(Time o1, Time o2) {
		// TODO Auto-generated method stub
		return (o1.getSt() - o2.getSt());
	}

}
