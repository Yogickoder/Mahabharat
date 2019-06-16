package vishal.amaze.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import vishal.amaze.qa.base.TestBase;
import vishal.amaze.qa.utility.Flasher;

public class LoginPage extends TestBase {
	
//Page Factory or Object Repository
	
@FindBy(name = "email")
WebElement username1;
	
@FindBy(xpath= "//*[@id='continue']")
WebElement continuebtn;

/*@FindBy(xpath= "//input[@id='signInSubmit']")
WebElement login1;*/

//String OTPFlag;
	
public LoginPage()//constructor for initializing the webElements.
	{
		PageFactory.initElements(driver, this);
	}
	
//Actions
public void Login(String un, String pswd)
{
	
	System.out.println("Driver initialized as = " +driver);
	username1.clear();
	
	wait.until(ExpectedConditions.elementToBeClickable(username1)).sendKeys(prop.getProperty("username"));
	Flasher.highLightElement(driver, username1);//this will highlight the current element.
	
	wait.until(ExpectedConditions.elementToBeClickable(continuebtn)).click();
	
	/*I defined these 2 elements here because I was getting Stale Element exception for below
	as these two elements comes once we click on the continue button due to which we cant declare and 
	initialize them at top object repository*/
	
	WebElement password = driver.findElement(By.name("password"));
    WebElement signin = driver.findElement(By.className("a-button-input"));// you can use driver.findelements its totally fine in Page Factory.
    WebElement login1 = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
    wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(prop.getProperty("password"));
    Flasher.highLightElement(driver, password);
	
    wait.until(ExpectedConditions.elementToBeClickable(login1)).click();
   // wait.until(ExpectedConditions.elementToBeClickable(loginOTP)).click();
    
	//return new HomepageafterLogin();
	//h.highLightElement(driver, signin);
	
	
}

}
