package vishal.amaze.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;

import vishal.amaze.qa.base.TestBase;
import vishal.amaze.qa.pages.HomepagebeforeLogin;
import vishal.amaze.qa.pages.LoginPage;
import vishal.amaze.qa.utility.FilloReader;

public class LoginPageTest extends TestBase {
	
HomepagebeforeLogin hmbeforelogin;// we will need this object for calling methods of HomepagebeforeLogin.
LoginPage loginpage;
FilloReader fil;
	

public LoginPageTest()
{
 super(); // this will call the parent constructor which is in TestBase 
          // so that all the prop and other data are initialized.
}

@BeforeMethod
public void setup() throws FilloException
{
	initialize();// This will load the driver, set the waits and all present in TestBase
	hmbeforelogin = new HomepagebeforeLogin();//object created
	loginpage = new LoginPage();
	hmbeforelogin.clickSignIn();// as once this method is called it will return LoginPage class object.
	fil = new FilloReader();
	System.out.println("Going to execute Fillo code");
	fil.getFilodata();
	

}

@Test
public void justLogin()
{
loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
//return new HomepageafterLogin();
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
