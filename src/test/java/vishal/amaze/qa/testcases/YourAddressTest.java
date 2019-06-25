package vishal.amaze.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;

import vishal.amaze.qa.base.TestBase;
import vishal.amaze.qa.pages.HomepageafterLogin;
import vishal.amaze.qa.pages.HomepagebeforeLogin;
import vishal.amaze.qa.pages.LoginPage;
import vishal.amaze.qa.pages.YourAccount;
import vishal.amaze.qa.pages.YourAddress;
import vishal.amaze.qa.utility.ExcelConfig;
import vishal.amaze.qa.utility.FilloReader;

public class YourAddressTest extends TestBase{
	
	
	HomepagebeforeLogin hmbeforelogin;
	LoginPage loginpage;
	HomepageafterLogin hmafterlogin;
	YourAccount youracc;
	YourAddress youradd;
	FilloReader fil;
	
	
	public YourAddressTest()
	{
		super();
	}
	
	@BeforeTest
	public void setup() throws FilloException
	  {
		initialize();
		hmbeforelogin = new HomepagebeforeLogin();
		hmbeforelogin.clickSignIn();
		loginpage = new LoginPage();
		loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		hmafterlogin = new HomepageafterLogin();
		hmafterlogin.inYourAccount();
		youracc = new YourAccount();
		youradd = new YourAddress();
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
