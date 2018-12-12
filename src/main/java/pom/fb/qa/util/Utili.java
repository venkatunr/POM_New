package pom.fb.qa.util;

import pom.fb.qa.base.TestBase;

public class Utili extends TestBase {

	public static long PAGE_LOAD_TIMEOUT=30;
	public static long IMPLICT_WAIT=30;

	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
}
