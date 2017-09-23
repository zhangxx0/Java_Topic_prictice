package thread.basic;


public class StopTest {
	public static void main(String[] args) {
		StopThread stopThread = new StopThread();
		new Thread(stopThread).start();
		
		for (int i = 0; i < 100; i++) {
			if (i == 50) {
				stopThread.stop();
			}
			System.out.println("main---"+i);
		}
	}
}
class StopThread implements Runnable {
	private boolean flag =true;
	@Override
	public void run() {
		//2)、线程体使用该标识
		while(flag){
			System.out.println("study thread....");
		}
	}
	//3)、对外提供方法改变标识
	public void stop(){
		this.flag =false;
	}
}
class Study implements Runnable{
	 //1)、线程类中 定义 线程体使用的标识	 
	private boolean flag =true;
	@Override
	public void run() {
		//2)、线程体使用该标识
		while(flag){
			System.out.println("study thread....");
		}
	}
	//3)、对外提供方法改变标识
	public void stop(){
		this.flag =false;
	}
	
}