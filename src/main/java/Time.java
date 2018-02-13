
public class Time {
		int st;
		int end;

		public Time(int st, int end) {
			super();
			this.st = st;
			this.end = end;
		}

		public int getSt() {
			return st;
		}

		public void setSt(int st) {
			this.st = st;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		@Override
		public String toString() {
			return "Time [st=" + st + ", end=" + end + "]";
		}
		
		

	}