package com.bfxy.threadpool;

public class MyTask implements Runnable {

	private int taskId;
	
	public MyTask(int taskId) {
		this.taskId = taskId;
	}

	public MyTask() {
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	@Override
	public void run() {
		try {
			System.err.println("run taskID = " + this.taskId);
			Thread.sleep(5 * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
