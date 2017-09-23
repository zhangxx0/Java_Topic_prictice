package thread.basic;

/**
 * 线程的创建1
 * @author xinxin
 */
public class CreateThread1 {
	public static void main(String[] args) {
		System.out.println("主线程ID:"+Thread.currentThread().getId());
		MyThread myThread = new MyThread("子线程1");
		myThread.start();
		MyThread myThread2 = new MyThread("子线程2");
		myThread2.run();
	}
}
class MyThread extends Thread {
	private String name;
	public MyThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name+",ID:"+Thread.currentThread().getId());
	}
}
