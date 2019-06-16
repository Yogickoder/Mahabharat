package vishal.amaze.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import vishal.amaze.qa.base.TestBase;
import vishal.amaze.qa.pages.HomepagebeforeLogin;

public class HomepagebeforeLoginTest extends TestBase{
	
HomepagebeforeLogin hmbeforelogin;	
	
public HomepagebeforeLoginTest()
  {
	super(); // This will load the properties file present in TestBase.
  }
  
@BeforeMethod
public void setup()
  {
  	initialize();// This will load the driver, set the waits and all present in TestBase
  	hmbeforelogin = new HomepagebeforeLogin();
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
