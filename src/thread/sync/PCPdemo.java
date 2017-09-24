package thread.sync;

public class PCPdemo {
	public static void main(String[] args) {
		Mantou mantou = new Mantou();
		
		Chihuo chihuo = new Chihuo(mantou);
		Maker maker = new Maker(mantou);
		
		new Thread(chihuo).start();
		new Thread(maker).start();
	}

}
class Chihuo implements Runnable{
	private Mantou mantou;
	
	public Chihuo(Mantou mantou) {
		super();
		this.mantou = mantou;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.mantou.consume();;
		}
	}
	
}
class Maker implements Runnable {
	private Mantou mantou;
	
	public Maker(Mantou mantou) {
		super();
		this.mantou = mantou;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.mantou.produce();
		}
	}
	
}
class Mantou {
	private static final int MAX_PRODUCT = 10;
	private static final int MIN_PRODUCT = 0;
	private int product = 0;
	
	/**
	 * 生产者生产出来的产品交给店员
	 */
	public synchronized void produce() {
		if (this.product >= MAX_PRODUCT) {
			try {
				wait();
				System.out.println("产品已满,请稍候再生产");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return;
		}

		this.product++;
		System.out.println("生产者生产第" + this.product + "个产品.");
		notifyAll(); // 通知等待区的消费者可以取出产品了
	}

	/**
	 * 消费者从店员取产品
	 */
	public synchronized void consume() {
		if (this.product <= MIN_PRODUCT) {
			try {
				wait();
				System.out.println("缺货,稍候再取");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return;
		}

		System.out.println("消费者取走了第" + this.product + "个产品.");
		this.product--;
		notifyAll(); // 通知等待去的生产者可以生产产品了
	}
}