package com.bfxy.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UseThreadPoolExecutor {

	
	
	public static void main(String[] args) {

		ThreadPoolExecutor pool = new ThreadPoolExecutor(
				1, 		//core
				3, 		//max			//无界队列 max参数 没有作用
				60L, 	//keepalivedTime	
				TimeUnit.SECONDS,	//单位
				new LinkedBlockingQueue<>(), //new ArrayBlockingQueue<>(2),		//有界队列
				new ThreadFactory() {
					@Override
					public Thread newThread(Runnable r) {
						Thread th = new Thread(r, "order-thread");
						if(th.isDaemon()){
							th.setDaemon(false);
						}
						if(th.getPriority() != Thread.NORM_PRIORITY){
							th.setPriority(Thread.NORM_PRIORITY);
						}
						return th;
					}
				},
				new RejectedExecutionHandler() {
					@Override
					public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
						System.err.println("补偿策略的代码: " + r);
						
					}
				}
		);
		
		
		MyTask t1 = new MyTask(1);
		MyTask t2 = new MyTask(2);
		MyTask t3 = new MyTask(3);
		MyTask t4 = new MyTask(4);
		MyTask t5 = new MyTask(5);
		MyTask t6 = new MyTask(6);
		
		
		
		//1 若有新的任务需要执行，如果线程池实际线程数小于corePoolSize，则优先创建线程
		pool.execute(t1);
		//2 若大于corePoolSize，则会将任务加入队列
		pool.execute(t2);
		pool.execute(t3);
		
		//3 若队列已满，则在总线程数不大于maximumPoolSize的前提下，创建新的线程
		pool.execute(t4);
		pool.execute(t5);
		
		//4 若线程数大于maximumPoolSize，则执行拒绝策略。或其他自定义方式。
		pool.execute(t6);
		
		
		
		//Runtime.getRuntime().addShutdownHook(hook);
		
		
		
		
		
		
		
	}
}
