package pom.fb.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pom.fb.qa.base.TestBase;

public class ContactsPage extends TestBase 
{

@FindBy(xpath="//td[contains(text(),'Contacts')]")
WebElement ContactsLabel;

@FindBy(xpath="//input[@name='first_name']")
WebElement firstName;

@FindBy(xpath="//input[@id='surname']")
WebElement lastName;

@FindBy(xpath="//input[@name='client_lookup']")
WebElement company;


public ContactsPage()
{
	PageFactory.initElements(driver, this);
}

public boolean verifyContactsLabel()
{
	return ContactsLabel.isDisplayed();
}

public void verifyContactList() throws InterruptedException
{
//	WebElement ele=driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']"));
	WebElement ele=driver.findElement(By.xpath("//a[text()='bijili bijili']//parent::td//preceding-sibling::td//input"));
    Thread.sleep(2000);
	ele.click();
}

public void createNewContacts(String title,String ftName,String ltName,String compa)
{
Select select=new Select(driver.findElement(By.xpath("//select[@name='title']")));
select.selectByVisibleText(title);
firstName.sendKeys(ftName);
lastName.sendKeys(ltName);
company.sendKeys(compa);

}

}
