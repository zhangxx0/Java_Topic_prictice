package thread.visiable;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VolatileDemo {

	private Lock lock = new ReentrantLock();
	private volatile int num = 0; // 不能保证原子性
	private int num2 = 0; 
	private int number = 0;
	
	public int getNum(){
		return this.num;
	}
	public int getNum2(){
		return this.num2;
	}
	public int getNumber(){
		return this.number;
	}
	
	public void increaseNum(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.num++;
	}
	public void increaseNum2(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (this) { // 使用synchronized保证原子性
			this.num2++;
		}
	}
	
	public void increase(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock.lock(); // 使用lock保证原子性
		try {
			this.number++;
		} finally {
			lock.unlock();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final VolatileDemo volDemo = new VolatileDemo();
		for(int i = 0 ; i < 500 ; i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					volDemo.increaseNum();
					volDemo.increaseNum2();
					volDemo.increase();
				}
			}).start();
		}
		// 如果还有子线程在运行，主线程就让出CPU资源，
		// 直到所有的子线程都运行完了，主线程再继续往下执行
		while(Thread.activeCount() > 1){
			Thread.yield();
		}
		System.out.println("num : " + volDemo.getNum());
		System.out.println("num2 : " + volDemo.getNum2());
		System.out.println("number : " + volDemo.getNumber());
	}

}
