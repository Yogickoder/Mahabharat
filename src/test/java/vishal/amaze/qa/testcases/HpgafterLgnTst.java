package vishal.amaze.qa.testcases;

import java.net.MalformedURLException;

//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import vishal.amaze.qa.base.TestBase;
import vishal.amaze.qa.pages.HpgafterLgn;
import vishal.amaze.qa.pages.HpgbfreLgn;
import vishal.amaze.qa.pages.LginPge;


public class HpgafterLgnTst extends TestBase {
	
HpgbfreLgn hmbeforelogin;
LginPge loginpage;
HpgafterLgn hmafterlogin;
	
public HpgafterLgnTst()
 {
 super();
 }
	
@BeforeMethod
public void setup() throws MalformedURLException
  {
	initialize();
	hmbeforelogin = new HpgbfreLgn();
	hmbeforelogin.clickSignIn();
	loginpage = new LginPge();
	loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	hmafterlogin = new HpgafterLgn();
  }
	
/*@Test(priority=1)
public void validateTitle()
  {
	System.out.println("Title of the page for HomePageAfterLogin is  ="+driver.getTitle());
	String current_title = hmafterlogin.verifyTitle();
	Assert.assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in",current_title);
  }*/
	
@Test(priority=1)
public void InyouraccountPage()
  {
	    hmafterlogin.inYourAccount();
		//return new YourAccount();//As the landing page is YourAccount hence its class object.
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
