package thread.basic;

public class JoinTest {
	public static void main(String[] args) throws InterruptedException {
		JoinThread joinThread = new JoinThread();
		Thread thread = new Thread(joinThread);
		thread.start();
		
		for (int i = 0; i < 100; i++) {
			if (i == 20) {
				thread.join();//main阻塞...
			}
			System.out.println("main---"+i);
		}
	}
}
class JoinThread implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("join---"+i);
		}		
	}
	
}
