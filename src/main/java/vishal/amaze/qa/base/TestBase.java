package vishal.amaze.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
public static String nodeURL;
	
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

public static void initialize() throws MalformedURLException
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
  else if(browsername.equals("remote"))
  {
	    
	  System.out.println("As user has opted to run it on remote hence making the hub and node up");
	   
	  System.out.println("Making the Hub up on ip 4444 for this I have created a batch file and have written the commands in that.");  
	  
	    //ProcessBuilder processBuilder = new ProcessBuilder("C://Selenium Grid//Selenium-grid_3.14_Hub_port_4444.bat");
	  File dirhub = new File("C:\\Selenium Grid");
      ProcessBuilder pbhub = new ProcessBuilder("cmd.exe", "/C", "Start","Selenium-grid_3.14_Hub_port_4444.bat");
      pbhub.directory(dirhub);
      
      try {
		Process prhub = pbhub.start();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      System.out.println("waiting for 5 secs so that Hub is fully up and running");
      try {
		Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	    
	    
	    //  "C:\Selenium Grid\Selenium-grid_3.14_Hub_port_4444.bat"
	  
//	    ProcessBuilder pb = new ProcessBuilder();
//		pb.command("cmd","/c","Selenium-grid_3.14_Hub_port_4444.bat");
//		File dir = new File("C:\\Selenium Grid\\");
//		pb.directory(dir);
//		try {
//			Thread.sleep(6000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		Runtime rt = Runtime.getRuntime();
//		try {
//			rt.exec("cmd /c start" +"Selenium-grid_3.14_Hub_port_4444.bat");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	  
//		try {
//			Thread.sleep(6000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace()
//		}
      
      System.out.println("Now making the Chrome Node up and registering with hub");
      
      File dirchrome = new File("C:\\Selenium Grid");
      ProcessBuilder pbchrome = new ProcessBuilder("cmd.exe", "/C", "Start","Selenium-grid_3.14_Chrome_node_port_4546.bat");
      pbchrome.directory(dirchrome);
     
      try {
		Process pchrome = pbchrome.start();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
      System.out.println("waiting for 5 secs so that Chrome node is registered and running.");
      try {
		Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
		
	    nodeURL = "http://192.168.1.11:4546/wd/hub";
		System.out.println("Chrome Browser Test Environment created");
		DesiredCapabilities chromecaps = DesiredCapabilities.chrome();			
		chromecaps.setBrowserName("chrome");
		chromecaps.setPlatform(Platform.WINDOWS);
		
		driver = new RemoteWebDriver(new URL(nodeURL),chromecaps);
	  
	  
//	  DesiredCapabilities cap = new DesiredCapabilities();
//	  cap.setBrowserName("chrome");
//	  cap.setPlatform(Platform.WINDOWS);
//	  
//	  ChromeOptions options = new ChromeOptions();
//	  options.merge(cap);
//	  
//	  String HubURL ="http://192.168.1.11:4444/wd/hub";
//	  
//	  driver = new RemoteWebDriver(new URL(HubURL),options);
	  
	  
	  
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

public void SeleniumGrid()
{
	

}

}







