package thread.sync;

import javax.swing.plaf.synth.SynthSpinnerUI;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import generic.Test;

/**
 * 线程同步demo
 * 
 * @author xinxin
 *
 */
public class SyncDemo1 {
	public static void main(String[] args) {
		SyncThread syncThread = new SyncThread();

		Thread t1 = new Thread(syncThread);
		Thread t2 = new Thread(syncThread);
		Thread t3 = new Thread(syncThread);
		t1.start();
		t2.start();
		t3.start();
	}
}

class SyncThread implements Runnable {
	private int num = 10;
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			Test();
//			Test2();
		}
	}

	// 同步代码块
	public void Test() {
		synchronized (this) {
			if (num <= 0) {
				flag = false; // 跳出循环
				return;
			}
			try {
				Thread.sleep(1000); // 模拟 延时
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
		}
	}

	// 同步方法
	public synchronized void Test2() {
		if (num <= 0) {
			flag = false; // 跳出循环
			return;
		}
		try {
			Thread.sleep(1000); // 模拟 延时
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
	}
}