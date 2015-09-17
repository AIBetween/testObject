package com.sf.testObject.pool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadPool
{
	//系统繁忙的最大 任务数
	private static final int SYSTEM_BUSY_TASK_NUM = 150;
	//系统默认的worker 数量
	private static final int SYSTEM_DEFAULT_WORKDER_NUM = 5;
	private static boolean isBusy = false;
	//当前任务数量
	private static int taskNum = 0;
	private static List<Worker> workerGroup;
	public static List<Task> taskQueue = Collections.synchronizedList(new ArrayList<Task>());
	
	private static ThreadPool threadPool;
	
	/**
	 * 初始化 workerGroup中的worker【使用默认数量】并启动
	 */
	private ThreadPool()
	{
		workerGroup = new ArrayList<Worker>();
		for(int i = 0; i < SYSTEM_DEFAULT_WORKDER_NUM; i++)
		{
			Worker worder = new Worker(i + "worker", taskQueue);
			workerGroup.add(worder);
		}
		
		initWorkers();
	}
	
	private ThreadPool(int workerNum)
	{
		workerGroup = new ArrayList<Worker>();
		for(int i = 0; i < workerNum; i++)
		{
			Worker worder = new Worker(i + "worker", taskQueue);
			workerGroup.add(worder);
		}
	}
	
	/**
	 * 启动worderGroup 中的所有worker 线程
	 */
	private void initWorkers()
	{
		for(Worker temWorker : workerGroup)
		{
			temWorker.start();
		}
	}
	
	/**
	 * 得到 线程池实例
	 * @return
	 */
	public static synchronized ThreadPool getInstance()
	{
		if(null == threadPool)
		{
			threadPool = new ThreadPool();
			
		}
		
		return threadPool;
	}
	
	/**
	 * 添加一个任务
	 * @param task
	 */
	public void addTask(Task task)
	{
		synchronized (taskQueue) {
		
			if(isBusy)
				return;
			
			taskNum++;
			if(taskNum > SYSTEM_BUSY_TASK_NUM)
				isBusy = true;
			
			taskQueue.add(task);
			
			taskQueue.notifyAll();
		}
	}
	
}
