package pom.fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pom.fb.qa.base.TestBase;

public class HomePage extends TestBase
{
	
@FindBy(xpath="//td[contains(text(),'User: venkadesh kumar ')]")
WebElement usernameLabel;
	
@FindBy(xpath="//a[contains(text(),'Calendar')]")
WebElement calender;

@FindBy(xpath="//a[contains(text(),'Companies')]")
WebElement companies;

@FindBy(xpath="//a[contains(text(),'Contacts')]")
WebElement Contacts;

@FindBy(xpath="//a[contains(text(),'New Contact')]")
WebElement newContactlink;

public HomePage()
{
	PageFactory.initElements(driver, this);
}

public String verifyHomePageTitle()
{
	return driver.getTitle();
}

public boolean verfiyUserLoginName()
{
 return usernameLabel.isDisplayed(); 
}

public ContactsPage verifyContactclick()
{
	Contacts.click();
    return new ContactsPage();
}

public void newContactClick()
{
	Actions action=new Actions(driver);
	action.moveToElement(Contacts).build().perform();
	newContactlink.click();
}
}


