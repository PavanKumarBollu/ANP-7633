package multithreading;

public class ExtendingThreadClass extends Thread{

	public ExtendingThreadClass() {
		System.out.println("Child Thread : " + this);
	}

	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("Child Thread :" + i);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			System.out.println("Child Thread Interrupted");
		}
	}
	

}
