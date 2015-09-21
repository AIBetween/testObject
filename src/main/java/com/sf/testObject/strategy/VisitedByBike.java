package com.sf.testObject.strategy;

import java.text.MessageFormat;

public class VisitedByBike implements IVisitedType
{
	private String name;
	public VisitedByBike(String name)
	{
		this.name = name;
	}

	public void visited()
	{
		
		System.out.println(MessageFormat.format("type:{0}", this.name));
	}
	
}
