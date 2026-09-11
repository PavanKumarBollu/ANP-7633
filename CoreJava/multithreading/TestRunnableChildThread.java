package multithreading;

public class TestRunnableChildThread {
	public static void main(String[] args) throws InterruptedException {
		
		NewThread nt = new NewThread();
		
		nt.t.start();
		
		for(int i = 0; i<10; i++)
		 {
			 System.out.println("Main Thread"+i);
			 Thread.sleep(1000);
		 }
	
		System.out.println("Main Thread is getting stopped");
		
	}
}
