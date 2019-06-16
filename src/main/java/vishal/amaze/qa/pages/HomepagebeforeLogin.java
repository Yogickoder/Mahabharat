package vishal.amaze.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import vishal.amaze.qa.base.TestBase;
import vishal.amaze.qa.utility.Flasher;

public class HomepagebeforeLogin extends TestBase{
	
//will declare the variables here or Object Repository.

//old @FindBy(xpath = "//*[@id='nav-link-yourAccount']/span[1]")
@FindBy(xpath = "//*[@id='nav-link-accountList']")
WebElement HelloSignin;


@FindBy(xpath = "//*[@id='nav-flyout-ya-signin']/a/span")
WebElement Signinclick;

@FindBy(xpath = "//*[@id='twotabsearchtextbox']")
WebElement searchbox;

public HomepagebeforeLogin() //constructor for initializing the webElements.
  {
	PageFactory.initElements(driver, this);
  }

public void clickSignIn()//this method will click on signin btn present on homepage and will open the login page.
{
	    wait.until(ExpectedConditions.elementToBeClickable(HelloSignin));
		Actions act = new Actions(driver);// Declare Actions object
		act.moveToElement(HelloSignin).build().perform();
		Flasher.highLightElement(driver, HelloSignin);
		act.moveToElement(Signinclick).build().perform();
		Flasher.highLightElement(driver, Signinclick);
		act.click(Signinclick).perform();
		//return new LoginPage();
}

public String validatehomepagetitle()// This will return the title of Homepage.
{
	System.out.println("Title of the page is ="+driver.getTitle());
	return driver.getTitle();
}

}
