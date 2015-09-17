package com.sf.testObject;

import static org.junit.Assert.*;

import org.junit.Test;

public class InitMappingTest
{

	@Test
	public void testGetStateStr()
	{
		assertEquals("整车可信", InitMapping.getStateStr(BarRecordStatus.VEHICLE_CREDIBLE));
	}

	@Test
	public void testGetOpCodeStr()
	{
		assertEquals("装件入包", InitMapping.getOpCodeStr("21"));
	}

	@Test
	public void testGetObjTypeStr()
	{
		assertEquals("普通运单", InitMapping.getObjTypeStr("20"));
	}

}
