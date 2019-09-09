package vishal.amaze.qa.testcases;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import vishal.amaze.qa.base.TestBase;
import vishal.amaze.qa.pages.HpgafterLgn;
import vishal.amaze.qa.pages.HpgbfreLgn;
import vishal.amaze.qa.pages.LginPge;
import vishal.amaze.qa.pages.YrAccount;

public class YrAccountTst extends TestBase{
	
	HpgbfreLgn hmbeforelogin;
	LginPge loginpage;
	HpgafterLgn hmafterlogin;
	YrAccount youracc;
	
	public YrAccountTst()
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
		hmafterlogin.inYourAccount();
		youracc = new YrAccount();
		
		
	  }
	
	@Test
	public void click_yourAdd()
	{
		youracc.click_YourAddresses();
		
	}
	
	@Test
	public void click_yourOder()
	{
		youracc.click_YourOrders();
		
	}
	
	@Test
	public void click_Log_Securty()
	{
		youracc.click_Login_Security();
		
	}
	
	@Test
	public void click_Paymnt_Opt()
	{
		youracc.click_PaymentOptions();
	}
	
	@Test
	public void click_Amzn_Pay_bal()
	{
		youracc.click_AmazonpayBalance();
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
