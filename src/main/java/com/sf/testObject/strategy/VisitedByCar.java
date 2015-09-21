package com.sf.testObject.strategy;

public class VisitedByCar implements IVisitedType
{
	private String name;
	public VisitedByCar(String name)
	{
		this.name = name;
	}
	public void visited()
	{
		System.out.println("type:" + this.name);
		
	}

}
