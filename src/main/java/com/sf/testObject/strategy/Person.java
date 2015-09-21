package com.sf.testObject.strategy;

public class Person
{
	private IVisitedType visitedType;
	public Person(IVisitedType visitedType)
	{
		this.visitedType = visitedType;
	}
	
	public void printVisitedResult()
	{
		visitedType.visited();
	}
	
	public static void main(String[] args)
	{
		
	}
	
}
