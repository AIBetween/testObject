package com.sf.testObject;

import static org.junit.Assert.*;

import org.junit.Test;
import com.sf.testObject.BarRecordStatus;

public class TranslateTest
{

	@Test
	public void testTranslateAndPrint()
	{
		Translate.translateAndPrint(   "1231", "755A", "30", "3331", "", "7200000", "20", "755A755B1000", BarRecordStatus.CREDIBLE,
                "3331", "755B", "31", "3331", "", "10800000", "60", "", BarRecordStatus.SUSPICIOUS,
                "1231", "755B", "31", "3331", "", "10800500", "20", "", BarRecordStatus.VEHICLE_CREDIBLE);
	}

}
