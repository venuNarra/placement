package thread;

public class Thread1 extends Thread{
	@Override
		public void run() {
			// TODO Auto-generated method stub
		try {
			System.out.println(Thread.currentThread().getName());
		}catch(Exception ex) {
			System.out.println("Exception");
		}
		}
	
public static void main(String[] args) {
	for(int i=0;i<8;i++) {
	Thread1 t1=new Thread1();
	t1.start();
	}
}
}
