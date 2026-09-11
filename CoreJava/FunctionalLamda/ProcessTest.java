package FunctionalLamda;

public class ProcessTest{

	public static void main(String[] args) {
		ProcessMessage processer = msg -> {
			System.out.println("Text Sent is :" + msg);
		};
		
		processer.handleMessage("Pavan");
		processer.handleMessage("How are you");
	}

}
