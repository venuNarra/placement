package thread;

public class Thread2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
	}
	public static void main(String[] args) {
		Thread2 t2=new Thread2();
		for(int i=0;i<8;i++) {
		Thread t=new Thread(t2);
		t.start();
		}
	}

}
