package com.sf.testObject.pool;

public class PoolTestMain
{
	public static void main(String[] args)
	{
		ThreadPool threadPool = ThreadPool.getInstance();
		for(int i = 0; i < 100; i++)
		{
			threadPool.addTask(new Task("task:" + i));
		}
		
		
	}
}
