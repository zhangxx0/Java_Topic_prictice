package thread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABC {
	private static int state = 0;

	public static void main(String[] args) {
		final Lock l = new ReentrantLock();

		Thread A = new Thread(new Runnable() {
			@Override
			public void run() {
				while (state <= 7) {
					l.lock();
					if (state % 3 == 0) {
						System.out.println("A"+state);
						state++;
					}
					l.unlock();
				}
			}
		});
		Thread B = new Thread(new Runnable() {
			@Override
			public void run() {
				while (state <= 7) {
					l.lock();
					if (state % 3 == 1) {
						System.out.println("B"+state);
						state++;
					}
					l.unlock();
				}
			}
		});
		Thread C = new Thread(new Runnable() {

			@Override
			public void run() {
				while (state <= 7) {
					l.lock();
					if (state % 3 == 2) {
						System.out.println("C"+state);
						state++;
					}
					l.unlock();
				}
			}
		});
		A.start();
		B.start();
		C.start();
	}
}
