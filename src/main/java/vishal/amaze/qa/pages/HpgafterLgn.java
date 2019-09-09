package vishal.amaze.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import vishal.amaze.qa.base.TestBase;

public class HpgafterLgn extends TestBase{
	
//Declaring all variables	//*[@id="nav-link-yourAccount"]/span[2]
//@FindBy(xpath = "//*[@id='nav-link-yourAccount']/span[2]")	
//WebElement usersignedname;
	
////*[@class='nav-line-1'][text()='Hello, vishal']

@FindBy(xpath = "//*[@class='nav-line-1'][text()='Hello, Karna']")
WebElement usersignedname;

@FindBy(xpath="//*[@class='nav-text'][text()='Your Account']")
WebElement youraccount;

@FindBy(xpath ="//*[@id='nav-your-amazon-text']")
WebElement myamaozn;
	
public HpgafterLgn()//constructor for initializing the webElements.
    {
	PageFactory.initElements(driver,this);
	}

public void inYourAccount()//This will click on youraccount and new landing page named YourAccount will open.
{
	wait.until(ExpectedConditions.elementToBeClickable(usersignedname));
	Actions act = new Actions(driver);// Declare Actions object
	act.moveToElement(usersignedname).build().perform();
	act.moveToElement(youraccount).build().perform();
	act.click(youraccount).perform();
	//return new YourAccount();//Landing page is your account
}

public boolean verifySignin()
{
if(usersignedname.getText().contains("Karna"))
{
	System.out.println("Sign in successfull");
	return true;
}
else
{
	System.out.println("Sign in failed, not in Sign in page");
	return false;
}

}

public String verifyTitle()
{
	System.out.println("Title of the page is ="+ driver.getTitle());
	return driver.getTitle();
}



}
