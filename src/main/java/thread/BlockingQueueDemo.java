package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {
public static void main(String[] args) {
	BlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue<Integer>(10);
	Thread t1=new Thread(new Producer1(blockingQueue));
	Thread t2=new Thread(new Consumer1(blockingQueue));
	t1.start();
	t2.start();
}
}
class Producer1 implements Runnable{
	BlockingQueue<Integer> blockingQueue=null;
	int i=0;

	public Producer1(BlockingQueue<Integer> blockingQueue) {
	super();
	this.blockingQueue = blockingQueue;
}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				produce(i++);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void produce(int i) throws InterruptedException {
		System.out.println("produced element: "+ i);
		blockingQueue.put(i);
		Thread.sleep(100);
	}
}
class Consumer1 implements Runnable{
	BlockingQueue<Integer> blockingQueue=null;

	public Consumer1(BlockingQueue<Integer> blockingQueue) {
	super();
	this.blockingQueue = blockingQueue;
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
		Integer out=blockingQueue.take();
		System.out.println("consuming element: "+out);
		Thread.sleep(1000);
	}
}
