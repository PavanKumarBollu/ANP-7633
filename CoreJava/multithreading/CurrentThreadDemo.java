package multithreading;

public class CurrentThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		
		 Thread thread = Thread.currentThread(); // ctrl + 2 , l
		 System.out.println(thread.getName());
		 thread.setName("My Thread");
		 System.out.println(thread.getName());
		 
		 
		 for(int i = 0; i<10; i++)
		 {
			 System.out.println(i);
			 Thread.sleep(1000);
		 }
		
	}

}
