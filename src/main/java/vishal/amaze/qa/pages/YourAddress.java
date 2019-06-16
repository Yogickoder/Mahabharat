package vishal.amaze.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import vishal.amaze.qa.base.TestBase;
import vishal.amaze.qa.utility.Flasher;

public class YourAddress extends TestBase{
	
	@FindBy(xpath = "//*[@id='ya-myab-plus-address-icon']")
	WebElement AddAdress;
	
	@FindBy(xpath = "//input[@name='address-ui-widgets-enterAddressFullName']")
	WebElement Fullname;
	
	@FindBy(xpath = "//input[@name='address-ui-widgets-enterAddressPhoneNumber']")
	WebElement MobileNumber;
	
	@FindBy(xpath = "//input[@name='address-ui-widgets-enterAddressPostalCode']")
	WebElement Pincode;
	
	
	@FindBy(xpath = "//input[@name='address-ui-widgets-enterAddressLine1']")
	WebElement Addline1;
	
	@FindBy(xpath = "//input[@name='address-ui-widgets-enterAddressLine2']")
	WebElement Addline2;
	
	@FindBy(xpath = "//input[@name='address-ui-widgets-landmark']")
	WebElement Landmark;
	
	@FindBy(xpath = "//input[@name='address-ui-widgets-enterAddressCity']")
	WebElement City;
	
	@FindBy(xpath = "//*[@name='address-ui-widgets-enterAddressStateOrRegion']")
	WebElement Selectstate;
	
	@FindBy(xpath = "//*[@id='a-autoid-0']")
	WebElement AddAdressbtn;

	
	//*[@name='address-ui-widgets-countryCode']
	
	public YourAddress() //constructor for initializing the webElements.
	  {
		PageFactory.initElements(driver, this);
	  }
	
	
	
	public void add_address()
	{
		wait.until(ExpectedConditions.elementToBeClickable(AddAdress)).click();
		//AddAdress.click();
		
	}
	
	public void fill_address_details(String fname,String mob,String pincde,String addln1, String addln2, String lndmark,String cty)
	{
		wait.until(ExpectedConditions.elementToBeClickable(Fullname)).sendKeys(fname);
		Flasher.highLightElement(driver, Fullname);
		wait.until(ExpectedConditions.elementToBeClickable(MobileNumber)).sendKeys(mob);
		Flasher.highLightElement(driver, MobileNumber);
		wait.until(ExpectedConditions.elementToBeClickable(Pincode)).sendKeys(pincde);
		Flasher.highLightElement(driver, Pincode);
		wait.until(ExpectedConditions.elementToBeClickable(Addline1)).sendKeys(addln1);
		Flasher.highLightElement(driver, Addline1);
		wait.until(ExpectedConditions.elementToBeClickable(Addline2)).sendKeys(addln2);
		Flasher.highLightElement(driver, Addline2);
		wait.until(ExpectedConditions.elementToBeClickable(Landmark)).sendKeys(lndmark);
		Flasher.highLightElement(driver, Landmark);
		wait.until(ExpectedConditions.elementToBeClickable(City)).clear();
		City.sendKeys(cty);
		
		Select stselect = new Select(Selectstate);
		stselect.selectByVisibleText("MAHARASHTRA");
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].scrollIntoView();", AddAdressbtn);
	    //js.executeScript("window.scrollBy(0,1000)"); //Scroll vertically down by 1000 pixels
		wait.until(ExpectedConditions.elementToBeClickable(AddAdressbtn)).click();
		WebElement upAddbtn = driver.findElement(By.xpath("//*[@class='a-alert-heading']"));
		
		if(driver.getPageSource().contains("Update your address "))
		    {
			System.out.println("It is asking for confirm address update hence we have to click on the add adress btn again");
			wait.until(ExpectedConditions.elementToBeClickable(AddAdressbtn)).click();
			}
		else
		    {
			System.out.println("Direct addition");
			}
		
		
	}

}
