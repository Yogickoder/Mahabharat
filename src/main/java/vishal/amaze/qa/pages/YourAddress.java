package vishal.amaze.qa.pages;

import java.util.List;

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
	
	@FindBy(xpath = "//*[text()='Add address']")
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
	
	
	
	public void add_Address()
	{
		wait.until(ExpectedConditions.elementToBeClickable(AddAdress)).click();
		//AddAdress.click();
		
	}
	
	public void enter_Fullname(String fname)
	{
		wait.until(ExpectedConditions.elementToBeClickable(Fullname)).sendKeys(fname);
		Flasher.highLightElement(driver, Fullname);	
	}
	
	public void enter_MobileNum(String mob)
	{
		wait.until(ExpectedConditions.elementToBeClickable(MobileNumber)).sendKeys(mob);
		Flasher.highLightElement(driver, MobileNumber);
	}
	
	public void enter_Pincode(String pincde)
	{
		wait.until(ExpectedConditions.elementToBeClickable(Pincode)).sendKeys(pincde);
		Flasher.highLightElement(driver, Pincode);
	}
	
	public void enter_Addline1(String addln1)
	{
		wait.until(ExpectedConditions.elementToBeClickable(Addline1)).sendKeys(addln1);
		Flasher.highLightElement(driver, Addline1);
	}
	
	public void enter_Addline2(String addln2)
	{
		wait.until(ExpectedConditions.elementToBeClickable(Addline2)).sendKeys(addln2);
		Flasher.highLightElement(driver, Addline2);
	}
	
	public void enter_Landmark(String lndmark)
	{
		wait.until(ExpectedConditions.elementToBeClickable(Landmark)).sendKeys(lndmark);
		Flasher.highLightElement(driver, Landmark);
	}
	
	public void enter_City(String cty)
	{
		wait.until(ExpectedConditions.elementToBeClickable(City)).clear();
		City.sendKeys(cty);
	}
	
	public void enter_State(String state)
	{
		Select stselect = new Select(Selectstate);
		stselect.selectByVisibleText(state);
		
	   //js.executeScript("window.scrollBy(0,1000)"); //Scroll vertically down by 1000 pixels
		
	}
	
	public void scrollToElement(WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].scrollIntoView();", ele);	
	}
	
	public void scrollByPixel(int pixels)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("window.scrollBy(0,pixels)"); //Scroll vertically down by 1000 pixels
	}
	
	
	
	public void click_AddAdressbtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(AddAdressbtn)).click();
	}
	
	public void textchk(String str,WebElement ele)
	{
		//
		if(driver.getPageSource().contains(str))
	    {
		System.out.println("The text ="+str+" is present.");
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
		}
	else
	    {
		System.out.println("Text not present normal flow will be exeuted");
		}
		
	}
	
	
	public void fill_address_details(String fname,String mob,String pincde,String addln1, String addln2, String lndmark,String cty)
	{
		String strUpAdd = "Update your address ";
		String strDupAdd = "You've submitted an address that is already in your address book.";
		String strAddsave ="Address saved";
		String strAddDelete ="Address deleted";
		String strstate = "MAHARASHTRA";
		
		YourAddress youradd = new YourAddress();// Object created
		// will call the locators methods in sequence
		youradd.enter_Fullname(fname);
		youradd.enter_MobileNum(mob);
		youradd.enter_Pincode(pincde);
		youradd.enter_Addline1(addln1);
		youradd.enter_Addline2(addln2);
		youradd.enter_Landmark(lndmark);
		youradd.enter_City(cty);
		youradd.enter_State(strstate);
		youradd.click_AddAdressbtn();
		youradd.textchk(strUpAdd, AddAdressbtn);//This method takes 2 parameters and if the text is present it will
		//click on the element provided.
		//youradd.countAddress();
		youradd.totalAddresse();
	}
	
	public void countAddress()
	{
		List<WebElement> AllAddress = driver.findElements(By.xpath("//*[contains(@id,'ya-myab-display-address-block-')]  "));
	    int count = AllAddress.size();
	    System.out.println("Total no of addresses added is = "+count);
	    //for(WebElement ele:AllAddress)
	    //{System.out.println(ele);}
	}
	
	public void totalAddresse()
	{
		////*[@id='address-ui-widgets-FullName']
		List<WebElement> allpeople = driver.findElements(By.xpath("//*[@id='address-ui-widgets-FullName']"));
	    int peoplecount = allpeople.size();
	    System.out.println("Total no of people added wrt Webelement = "+peoplecount);
	    String pnames[] = new String[peoplecount];
	    int i=0;
	    for(WebElement ele:allpeople)
	    {   
	    	if(ele.isDisplayed())
	        {
	    		 pnames[i]=ele.getText();
	             System.out.println("Person number = "+i+" having name as = "+ele.getText());
	             i++;
	        }
	    System.out.println("Current no of peoples are = "+i);	
	    }
	   // System.out.println(pnames);
		
		
	}

}
