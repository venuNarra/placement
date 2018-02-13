package thread;

public class OddEvenTest {
	boolean odd = true;
	int count = 1;

	public void printEven(int n) {
	
		synchronized (this) {
			while (count < n) {
				while (odd) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(count++);
				odd = true;
				notify();
			}
		}
	}

	public void printOdd(int n) {
		
		synchronized (this) {
			while (count < n) {
				while (!odd) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(count++);
				odd = false;
				notify();
			}
		}
	}

	public static void main(String[] args) {
		OddEvenTest test = new OddEvenTest();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				test.printOdd(10);

			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				test.printEven(10);

			}
		});
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main Exit");
	}
}
