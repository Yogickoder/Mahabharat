package vishal.amaze.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import vishal.amaze.qa.base.TestBase;
import vishal.amaze.qa.pages.HomepageafterLogin;
import vishal.amaze.qa.pages.HomepagebeforeLogin;
import vishal.amaze.qa.pages.LoginPage;
import vishal.amaze.qa.pages.YourAccount;

public class YourAccountTest extends TestBase{
	
	HomepagebeforeLogin hmbeforelogin;
	LoginPage loginpage;
	HomepageafterLogin hmafterlogin;
	YourAccount youracc;
	
	public YourAccountTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	  {
		initialize();
		hmbeforelogin = new HomepagebeforeLogin();
		hmbeforelogin.clickSignIn();
		loginpage = new LoginPage();
		loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		hmafterlogin = new HomepageafterLogin();
		hmafterlogin.inYourAccount();
		youracc = new YourAccount();
		
		
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
