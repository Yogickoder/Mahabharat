package vishal.amaze.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import vishal.amaze.qa.base.TestBase;

public class YourAccount extends TestBase {
	
	@FindBy(xpath = "//img[@alt='Your Addresses']")
	WebElement YourAddresses;
	
	@FindBy(xpath = "//img[@alt='Your Orders']")
	WebElement YourOrders;
	
	
	@FindBy(xpath = "//img[@alt='Login & security']")
	WebElement Login_Security;
	
	@FindBy(xpath = "//img[@alt='Payment options']")
	WebElement PaymentOptions;
	
	
	@FindBy(xpath = "//img[@alt='Amazon Pay balance']")
	WebElement AmazonpayBalance;
	
	public YourAccount() //constructor for initializing the webElements.
	  {
		PageFactory.initElements(driver, this);
	  }
	
	
	public void click_YourAddresses()
	{   
		wait.until(ExpectedConditions.elementToBeClickable(YourAddresses)).click();
		//YourAddresses.click();
	}
	
	public void click_YourOrders()
	{
		wait.until(ExpectedConditions.elementToBeClickable(YourOrders)).click();
		//YourOrders.click();
	}
	
	public void click_Login_Security()
	{
		wait.until(ExpectedConditions.elementToBeClickable(Login_Security)).click();
		//Login_Security.click();
	}
	
	public void click_PaymentOptions()
	{
		wait.until(ExpectedConditions.elementToBeClickable(PaymentOptions)).click();
		//PaymentOptions.click();
	}
	
	public void click_AmazonpayBalance()
	{
		wait.until(ExpectedConditions.elementToBeClickable(AmazonpayBalance)).click();
		//AmazonpayBalance.click();
	}
	
}
