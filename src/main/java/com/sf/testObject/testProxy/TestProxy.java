package com.sf.testObject.testProxy;

public class TestProxy
{
	public static void main(String[] args) throws Throwable
	{
		AccountProxy accountProxy = new AccountProxy();
		
		accountProxy.invoke(new AccountImpl(), AccountImpl.class.getMethod("getAccount"), new Object[]{});
		
	}
}
