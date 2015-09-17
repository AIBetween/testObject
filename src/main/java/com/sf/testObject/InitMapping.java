package com.sf.testObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class InitMapping
{
	private static Map<BarRecordStatus, String> stateMapping = new HashMap<BarRecordStatus, String>();
	private static Properties opCodes = new Properties();
	private static Map<String, String> ObjTypeMapping = new HashMap<String, String>();
	static
	{
		stateMapping.put(BarRecordStatus.CREDIBLE, "推断可信");
		stateMapping.put(BarRecordStatus.ADDED, "推断新增");
		stateMapping.put(BarRecordStatus.SUSPICIOUS, "推断可疑");
		stateMapping.put(BarRecordStatus.TEMP, "推断临时");
		stateMapping.put(BarRecordStatus.VEHICLE_CREDIBLE, "整车可信");
		stateMapping.put(BarRecordStatus.INDIVIDUAL_CREDIBLE,"单件可信");
		stateMapping.put(BarRecordStatus.PROCESS_SUSPICIOUS, "过程可疑");
		stateMapping.put(BarRecordStatus.BROADCAST_SUSPICIOUS, "广播可疑");
		stateMapping.put(BarRecordStatus.UPGRADE_ADDED, "升格新增");
		stateMapping.put(BarRecordStatus.UPGRADE_CREDIBLE, "升格可信");
		
		//加载 操作码映射
		try {
			opCodes.load(InitMapping.class.getResourceAsStream("/opCode.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ObjTypeMapping.put("10", "子运单");
		ObjTypeMapping.put("20", "普通运单");
		ObjTypeMapping.put("30", "包");
		ObjTypeMapping.put("40", "笼");
		ObjTypeMapping.put("50", "袋");
		ObjTypeMapping.put("60", "车");
		
	}
	
	public static String getStateStr(BarRecordStatus state)
	{
		return stateMapping.get(state);
	}
	
	public static String getOpCodeStr(String key)
	{
		return opCodes.getProperty(key);
	}
	
	public static String getObjTypeStr(String key)
	{
		return ObjTypeMapping.get(key);
	}
	
	
}
