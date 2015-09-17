package com.sf.testObject.testProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AccountProxy implements InvocationHandler
{
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		Object result = null;
		if("getAccount".equals(method.getName()))
		{
			System.out.println("getAccount begin");
			result = method.invoke(proxy, args);
			System.out.println("getAccount end");
		}
		else if("updateAccount".equals(method.getName()))
		{
			System.out.println("updateAccount begin");
			result = method.invoke(proxy, args);
			System.out.println("updateAccount end");
		}
		
		return result;
	}

}
