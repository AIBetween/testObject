package com.sf.testObject.pool;

import java.text.MessageFormat;

public class Task extends Thread
{
	
	public String name;
	public Task(String name)
	{
		this.name = name;
	}
	@Override
	public void run()
	{
		for(int i = 0; i < 10; i++)
		{
			System.out.println(MessageFormat.format("taskName:{0} is runing", this.name));
		}
	}
	
	@Override
	public String toString()
	{
		return this.name;
	}
}
