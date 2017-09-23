package thread.basic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



/**
 * 创建线程3
 * @author xinxin
 *
 */
public class CreateThread3 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Date date1 = new Date();
		int size = 5;
		// 创建线程池
		ExecutorService pool = Executors.newFixedThreadPool(size);
		List<Future> returnList = new ArrayList<Future>();
		for(int i=0;i<size;i++) {
			Callable callable = new MyThread3("子线程"+i);
			// 执行任务，并获取Future对象
			Future future = pool.submit(callable);
			returnList.add(future);
		}
		// 关闭线程池
		pool.shutdown();
		
		for(Future f:returnList) {
			System.out.println(f.get().toString());
		}
		
		Date date2 = new Date();
		System.out.println("主线程运行时间："+(date2.getTime()-date1.getTime())+"ms");
	}

}
class MyThread3 implements Callable<Object>{
	private String name;
	public MyThread3(String name) {
		this.name = name;
	}
	@Override
	public Object call() throws Exception {
		Date date1 = new Date();
		Thread.sleep(1000);
		Date date2 = new Date();
		long time = date2.getTime() - date1.getTime();
		return name+"运行了"+time+"ms";
	}

}