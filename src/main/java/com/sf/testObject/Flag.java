package com.sf.testObject;

public class Flag {

	int number = 1;
	
	public synchronized void printThreadName() throws Exception
	{
		if(number%3 == 1)
			System.out.println("A");
		else if(number%3 == 2)
			System.out.println("B");
		else if(number%3 == 0)
			System.out.println("C");
	
		number++;
	}
}
