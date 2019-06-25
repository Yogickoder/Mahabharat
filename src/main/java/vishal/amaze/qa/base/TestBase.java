package vishal.amaze.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import vishal.amaze.qa.utility.TestUtil;
import vishal.amaze.qa.utility.WebEventListener;

public class TestBase {
	
public static WebDriver driver;// WebDriver is an Interface and driver here is a variable.
public static Properties prop;//Properties is a class under Java.util
public static WebDriverWait wait;
public static EventFiringWebDriver e_driver;
public static WebEventListener event_listener;
	
//creating constructor
 public TestBase()
 {
	
 try {
	 prop = new Properties();// object created for Properties named prop.
	 FileInputStream input = new FileInputStream("/Users/DELL/workspace/MahabharatAll/src/main/java/vishal/amaze/qa/config/config.properties");
     prop.load(input);
 
 } catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 catch(IOException e)
 {
	 e.printStackTrace();
 }
}

public static void initialize()
{
 String browsername = prop.getProperty("browser");	
 if(browsername.equalsIgnoreCase("chrome"))
  { 
	 System.setProperty("webdriver.chrome.driver","E:\\automation\\Dr\\chromedriver.exe");//Set the driver path for browser
	 driver = new ChromeDriver();
  }else if(browsername.equalsIgnoreCase("Firefox"))
  {
	  System.setProperty("webdriver.gecko.driver","E:\\automation\\Dr\\geckodriver.exe");//Set the driver path for browser
		 driver = new FirefoxDriver();  
  }
 
 /*e_driver = new EventFiringWebDriver(driver);
 
 event_listener = new WebEventListener();
 e_driver.register(event_listener);
 driver = e_driver;*/
 driver.manage().window().maximize();
 driver.manage().deleteAllCookies();
 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
 driver.get(prop.getProperty("urlhomepage"));
 wait = new WebDriverWait(driver,30);

 }

}







