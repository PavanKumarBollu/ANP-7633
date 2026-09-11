package multithreading;

public class NewThread implements Runnable {
	Thread t;
	
	public NewThread()
	{
		t = new Thread(this, "Demo Thread");
	}

	@Override
	public void run() {
	try {
		for(int i = 0; i<10; i++)
		 {
			 System.out.println("Child Thread :" + i);
			 Thread.sleep(1000);
		 }
	} catch (Exception e) {
		System.out.println("Child Thread Inturepted");
	}
	System.out.println("Child Thread Got finshed");

	}

}
