package vishal.amaze.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import vishal.amaze.qa.base.TestBase;

public class Alllinks extends TestBase {
	
	
	 
		public static void alinks() 
		{

	      //String[] linksall = null;
		//String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
	 
		  java.util.List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		  System.out.println(driver.getCurrentUrl()+"---"+driver.getTitle());
	 
		  System.out.println(allLinks.size());//this will just tell the number of links present.
	     // int linksCount = allLinks.size();
	      for(WebElement link:allLinks){
				System.out.println(link.getText() + " - " + link.getAttribute("href"));
				driver.navigate().to(link.getAttribute("href"));
				
			//	driver.findElement(By.linkText("urlLink")).sendKeys(selectLinkOpeninNewTab);
			}
			       
			      

	 
		}
	 
	}



