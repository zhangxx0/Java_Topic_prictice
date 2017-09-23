package thread.basic;

/**
 * 创建线程2
 * 
 * @author xinxin
 *
 */
public class CreateThread2 {
	public static void main(String[] args) {
		MyThread2 myThread2 = new MyThread2();
		Thread thread = new Thread(myThread2);
		thread.start();
	}
}
class MyThread2 implements Runnable {
	@Override
	public void run() {
		System.out.println("this is s subthread");
	}
}