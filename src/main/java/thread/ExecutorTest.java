package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {
public static void main(String[] args) {
	ExecutorService executorService=Executors.newFixedThreadPool(10);
	for(int i=0;i<10;i++) {
	executorService.execute(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Asynchrounous Task"+Thread.currentThread().getName());
			//System.out.println(System.currentTimeMillis() +"  "+Thread.currentThread().getName());
			
		}
	});
	}
	executorService.shutdown();
	int  corePoolSize  =    5;
	int  maxPoolSize   =   10;
	long keepAliveTime = 5000;
	ExecutorService executorService2=new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
	executorService2.execute(new Thread1());
}
}
