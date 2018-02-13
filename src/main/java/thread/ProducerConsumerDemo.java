package thread;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> sharedList=new ArrayList<Integer>();
		
		Thread t1=new Thread(new Producer(sharedList));
		Thread t2=new Thread(new Consumer(sharedList));
		t1.start();
		t2.start();

	}

}
class Producer implements Runnable{
	List<Integer> sharedList=null;
	final int MAX_SIZE=5;
	private int i=0;
	
	
	public Producer(List<Integer> sharedList) {
		super();
		this.sharedList = sharedList;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				producer(i++);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void producer(int i) throws InterruptedException {
		synchronized (sharedList) {
			while(sharedList.size()==MAX_SIZE) {
				System.out.println("List is full and producer is waiting");
				sharedList.wait();
			}
			sharedList.add(i);
			System.out.println("producer is added: "+i);
			sharedList.notify();
			Thread.sleep(1000);

		}
	}
}


class Consumer implements Runnable{
	List<Integer> sharedList=null;
	final int MAX_SIZE=5;
	
	
	
	public Consumer(List<Integer> sharedList) {
		super();
		this.sharedList = sharedList;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				consumer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void consumer() throws InterruptedException {
		synchronized (sharedList) {
			while(sharedList.isEmpty()) {
				System.out.println("List is Empty...waiting for the producer");
				sharedList.wait();
			}
			int val=sharedList.remove(0);
			System.out.println("Removed the element from the list: "+val);
			sharedList.notify();
			Thread.sleep(1000);

			
		}
	}
}
