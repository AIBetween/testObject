package com.sf.testObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestSerializable implements Serializable
{
	private String username;
	private String password;
	public static Logger logger = LoggerFactory.getLogger(TestSerializable.class);
	@Override
	public String toString()
	{
		return MessageFormat.format("this is test, name is {0}, password is {1}", this.username, this.password).toString();
	}
	

	public static void main(String[] args)
	{
		TestSerializable testObj = new TestSerializable();
		
		testObj.setUsername("zhangsan");
		testObj.setPassword("yao63912");
		
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("d:/testSerial.txt")));
			objectOutputStream.writeObject(testObj);
			objectOutputStream.flush();
			
			//读取
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("d:/testSerial.txt")));
			Object object = objectInputStream.readObject();
			
			System.out.println(object);
		} catch (Exception e) {
			logger.error("文件不存在");
			e.printStackTrace();
		} 
	}
	
	
	public String getUsername()
	{
		return username;
	}


	public void setUsername(String username)
	{
		this.username = username;
	}


	public String getPassword()
	{
		return password;
	}


	public void setPassword(String password)
	{
		this.password = password;
	}


}
