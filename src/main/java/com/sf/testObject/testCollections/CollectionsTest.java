package com.sf.testObject.testCollections;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTest
{
	public static void main(String[] args)
	{
		List<String> testList = new ArrayList<String>();
		Collections.addAll(testList, new String[]{"zhangsan", "lisi", "wangwu"});
		System.out.println(printformat("addAll:{0}", testList.toString()));
		
		List<String> destList = new ArrayList<String>(8);
		Collections.addAll(destList, new String[]{"1", "2", "3", "4"});
		List<String> srcList = new ArrayList<String>();
		Collections.addAll(srcList, new String[]{"i", "am", "dest"});
		Collections.copy(destList, srcList);
		
		System.out.println(printformat("copy:{0}", destList.toString()));
		
		List<String> awaitFillList = new ArrayList<String>(4);
		Collections.addAll(awaitFillList, "wangwu", "wangwu", "wnagwu");
		Collections.fill(awaitFillList, "zhangsan");
		System.out.println(printformat("fillOp:{0}, listSize:{1}", awaitFillList, awaitFillList.size()));
		
		int frequencyOfZhangsan =  Collections.frequency(awaitFillList, "zhangsan");
		System.out.println(printformat("frequencyOp:{0}", frequencyOfZhangsan));
		
		Student student1 = new Student(25, "zhangsan");
		Student student2 = new Student(26, "lisi");
		Student student3 = new Student(6, "lisi");
		List<Student> studentGroup = new ArrayList<Student>();
		studentGroup.add(student2);
		studentGroup.add(student1);
		studentGroup.add(student3);
		
		Collections.sort(studentGroup);
		System.out.println(printformat("sortOp:{0}", studentGroup));
		
	}
	
	public static String printformat(String pattern, Object... values)
	{
		return MessageFormat.format(pattern, values);
	}
	
	
}

class Student implements Comparable<Student>
{
	private int age;
	private String name;
	
	public Student(int age, String name)
	{
		super();
		this.age = age;
		this.name = name;
	}

	public int compareTo(Student o)
	{
		return this.age - o.getAge();
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	@Override
	public String toString()
	{
		return MessageFormat.format("name:{0}, age:{1}", this.name, this.age);
	}
}
