package thread.create;

import java.util.concurrent.Callable;

public class Rabbit {

	
}

class RabbitThread extends Thread {

	@Override
	public void run() {
		
	}
	
}

class Tortoise implements Runnable {

	@Override
	public void run() {
		synchronized(this) {
			
		}
	}
}

class Three implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		
		return null;
	}
	
}
