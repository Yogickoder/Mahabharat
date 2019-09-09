package vishal.amaze.qa.testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import vishal.amaze.qa.base.TestBase;
import vishal.amaze.qa.pages.HpgbfreLgn;

public class HpgbfreLgnTst extends TestBase{
	
HpgbfreLgn hmbeforelogin;	
	
public HpgbfreLgnTst()
  {
	super(); // This will load the properties file present in TestBase.
  }
  
@BeforeMethod
public void setup() throws MalformedURLException
  {
  	initialize();// This will load the driver, set the waits and all present in TestBase
  	hmbeforelogin = new HpgbfreLgn();
  }
  
@Test
public void verifyTitleBefore()
  {
	String homepagetitle = hmbeforelogin.validatehomepagetitle();
	Assert.assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", homepagetitle);
	System.out.println("Correct page launched");  
  }
  
@AfterMethod
public void tearDown()
{
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.quit();
}

}
