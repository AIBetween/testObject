package com.sf.testObject;

public class TestThrow
{
	public void calculator(Integer a, Integer b) throws Exception 
	{
		if(a == null || b == null)
				throw new InvaildArgumentException("参数不合法");
		
		
		System.out.println("跑异常后的代码");
	}
	
	public static void main(String[] args) throws Exception
	{
			new TestThrow().calculator(null, null);
		
	}
}

class InvaildArgumentException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvaildArgumentException(String message)
	{
		super(message);
	}
}
