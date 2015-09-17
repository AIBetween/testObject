package com.sf.testObject.pool;

import java.util.List;

public class Worker extends Thread
{
	private boolean isRuning = false;
	private String name;
	private List<Task> taskQueue;
	public Worker(String name, List<Task> taskQueue)
	{
		this.name = name;
		this.taskQueue = taskQueue;
	}
	
	@Override
	public void run()
	{
		while(!isRuning)
		{
			Task willExecuteTask = null;
			synchronized(taskQueue)
			{
				while(taskQueue.isEmpty())
				{
					try {
						taskQueue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				willExecuteTask = taskQueue.remove(0);
				System.out.println(willExecuteTask.toString());
					
			}
			
			isRuning = true;
			willExecuteTask.start();
			isRuning = false;
		}
	}
	
}
