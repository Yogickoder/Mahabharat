package vishal.amaze.qa.testcases;

import java.io.File;
import java.net.MalformedURLException;

//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;

import vishal.amaze.qa.base.TestBase;
import vishal.amaze.qa.pages.HpgafterLgn;
import vishal.amaze.qa.pages.HpgbfreLgn;
import vishal.amaze.qa.pages.LginPge;
import vishal.amaze.qa.pages.YrAccount;
import vishal.amaze.qa.pages.YrAddress;
import vishal.amaze.qa.utility.ExcelConfig;
import vishal.amaze.qa.utility.FilloReader;

public class YrAddressTst extends TestBase{
	
	
	HpgbfreLgn hmbeforelogin;
	LginPge loginpage;
	HpgafterLgn hmafterlogin;
	YrAccount youracc;
	YrAddress youradd;
	FilloReader fil;
	
	
	public YrAddressTst()
	{
		super();
	}
	
	@BeforeTest
	public void setup() throws FilloException, MalformedURLException
	  {
		//ProcessBuilder pb = new ProcessBuilder("C:\\Selenium Grid\\Selenium-grid_3.14_Hub_port_4444.bat");
		
		initialize();
		hmbeforelogin = new HpgbfreLgn();
		hmbeforelogin.clickSignIn();
		loginpage = new LginPge();
		loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		hmafterlogin = new HpgafterLgn();
		hmafterlogin.inYourAccount();
		youracc = new YrAccount();
		youradd = new YrAddress();
		youracc.click_YourAddresses();
		
	}
	
	@DataProvider(name = "Addressdata")
	public Object[][] getAmzAdressdata()
	{
		Object[][] data = ExcelConfig.getTestdata("AmzAddAddress","C:\\Users\\DELL\\workspace\\MahabharatAll\\src\\test\\java\\inputFiles\\Amazontestdata.xlsx");
		return data;
		
	}
	
	@Test(dataProvider="Addressdata")
	public void generate_AddAddress(String fname,String mob,String pincde,String addln1, String addln2, String lndmark,String cty)
	{
		youradd.add_Address();
		youradd.fill_address_details(fname, mob, pincde, addln1, addln2, lndmark, cty);
	}
	
	/*@AfterMethod
	public void tearDown()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		//*[@id="yaab-alert-box"]/div/h4
	}*/
	

}
