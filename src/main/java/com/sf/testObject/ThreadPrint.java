package com.sf.testObject;

public class ThreadPrint implements Runnable 
{

	//prev和self 充当资源
	private Object prev;
	private Object self;
	
	public ThreadPrint(Object self, Object prev)
	{
		this.prev = prev;
		this.self = self;
	}
	
	public void printThreadName()
	{
		synchronized (prev) {
			synchronized (self) {
				System.out.println(Thread.currentThread().getName());
				
				self.notify();
			}
			
			try {
				prev.wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
	public void run()
	{
		for(int i = 0; i < 10; i++)
		{
			this.printThreadName();
		}
		
		System.exit(0);
		
	}   
	
	public static void main(String[] args) throws Exception
	{
		Object object1 = new Object();
		Object object2 = new Object();
		Object object3 = new Object();
		
		Thread threadA = new Thread(new ThreadPrint(object1, object3), "A");
		Thread threadB = new Thread(new ThreadPrint(object2, object1), "B");
		Thread threadC = new Thread(new ThreadPrint(object3, object2), "C");
		
		threadA.start();
		//确保线程的执行顺序
		Thread.sleep(10);
		threadB.start();
		Thread.sleep(10);
		threadC.start();
	}
   
}  