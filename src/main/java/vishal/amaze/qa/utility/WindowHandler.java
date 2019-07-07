//package vishal.amaze.qa.utility;
//import java.util.ArrayList;
//import java.util.Set;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.annotations.Test;
//
//import vishal.amaze.qa.base.TestBase;
//
//public class WindowHandler extends TestBase{
//		
//    public void wh() throws Exception {
//			  
//	String parent = driver.getWindowHandle();//This will return window string for parent page.
//	System.out.println("This is the current parent window string:- "+parent);
//
//	Set<String> aw = driver.getWindowHandles();
//
//	//ArrayList<String> tabs = new ArrayList<String>(aw);
//	//driver.switchTo().window(tabs.get(0));
//	
//	System.out.println(driver.getTitle());
//
//	//now aw contains all windows
//	int count = aw.size();// this will store the size
//
//	for(String child:aw)//Advanced for Loop
//	{
//		if(!parent.equalsIgnoreCase(child))
//		{
//			driver.switchTo().window(child);
//	        driver.manage().window().maximize();
//	        System.out.println("Child window max  :-"+driver.getWindowHandle());
//	        System.out.println(driver.getTitle());
//		}
//
//	}
//	
//  }
//}
//
