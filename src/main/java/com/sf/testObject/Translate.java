package com.sf.testObject;

import java.util.Date;

public class Translate
{

	
	public static void translateAndPrint(Object... values)
	{
		int i = 0;
		while(i <values.length)
		{
			StringBuffer buffer = new StringBuffer();
			buffer.append("\t" + values[i++]);
			buffer.append(" ");
			buffer.append("\t" +values[i++]);
			buffer.append(" ");
			buffer.append("\t"+values[i]+":" +InitMapping.getOpCodeStr((String)values[i++]));
			buffer.append(" ");
			buffer.append("\t" +values[i++]);
			buffer.append(" ");
			buffer.append("\t" +values[i++]);
			buffer.append(" ");
			buffer.append("\t" +values[i++]);
			buffer.append(" ");
			buffer.append("\t" +values[i]+":"+InitMapping.getObjTypeStr((String)values[i++]));
			buffer.append(" ");
			i++;
			buffer.append("\t" +InitMapping.getStateStr((BarRecordStatus)values[i++]));
		
			System.out.println(buffer.toString());
		}
	}
}
