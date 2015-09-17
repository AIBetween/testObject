package com.sf.testObject;

public class ThreadB implements Runnable{

	private Flag flag;
	public ThreadB(Flag flag)
	{
		this.flag = flag;
	}
	public void run() {
		
		for(int i = 0; i < 10; i++)
		{
			try {
				flag.printThreadName();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		
		Flag flag = new Flag();
		Thread threadA = new Thread(new ThreadB(flag));
		Thread threadB = new Thread(new ThreadB(flag));
		Thread threadC = new Thread(new ThreadB(flag));
		
		threadA.start();
		Thread.sleep(10);
		threadB.start();
		Thread.sleep(10);
		threadC.start();
	}
}
