package com.bfxy.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class UseCustomThreadPoolExecutor {

	
	public static void main(String[] args) {
		
		CustomThreadPoolExecutor ce = new CustomThreadPoolExecutor(1, 2, 10L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
		
		ce.execute(new MyTask(1));
		
		
		
	}
}
