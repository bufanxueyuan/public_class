package com.bfxy.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class UseExecutors {

	
	public static void main(String[] args) throws Exception {
		
		
		// 1 线程池里的线程数量 是 固定的 (你创建的时候传递的参数值 ->  5)
		// 2 这个底层使用了这个类 ->  new ThreadPoolExecutor  (但是有一个参数 , 队列是没有容量上限的 -> new LinkedBlockingQueue<Runnable>())
		//ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		//ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		//ExecutorService executorService = Executors.newCachedThreadPool();
		
		/**
		SynchronousQueue sq = new SynchronousQueue();
		new Thread(new Runnable() {
			@Override
			public void run() {
				Object obj;
				try {
					obj = sq.take();
					System.err.println("-----------: " + obj);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		Thread.sleep(50);
		sq.add(10);
		Thread.sleep(10000);
		*/
		
		//ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
		//executorService.scheduleWithFixedDelay(new MyTask(1), 5, 2, TimeUnit.SECONDS);
		
		
		//---------------    Timer    ------------------
		
		
		
		
		
		
		
		
		
		
	}
}
