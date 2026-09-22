package multithreading;

public class TestExtendingThreadClass {
	public static void main(String[] args) throws InterruptedException {
		
		
		ExtendingThreadClass etc = new ExtendingThreadClass();
		etc.start();
		
		for(int i = 0; i<10; i++)
		 {
			 System.out.println("Main Thread : "+i);
			 Thread.sleep(1000);
		 }
	
		System.out.println("Main Thread is getting stopped");
	}

}
