package thread.basic;

public class YieldTest extends Thread{
	
	public static void main(String[] args) {
		Thread thread = new YieldTest();
		thread.start();
		
		for (int i = 0; i < 100; i++) {
			if (i%10 == 0) {
				Thread.yield();
			}
			System.out.println("main---"+i);
		}
	}
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("yeild---"+i);
		}
	}
}
