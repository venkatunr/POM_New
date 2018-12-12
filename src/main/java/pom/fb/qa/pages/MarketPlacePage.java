package pom.fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.fb.qa.base.TestBase;
import pom.fb.qa.pages.HomePage;
import pom.fb.qa.pages.LoginPage;

public class MarketPlacePage extends TestBase{
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="pass")
	WebElement password;
	
	@FindBy(xpath="//i[contains(@class,'fb_logo img sp_n5C5Uq05yB8 sx_3bb273')]")
	WebElement icon;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement logInBtn;
	
	//Initialization
	public MarketPlacePage()
	{
		PageFactory.initElements(driver, this); // OR PageFactory.initElements(driver, this); 
	}
	
	
	//Actions
	public String validateTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateIcon()
	{
		return icon.isDisplayed();
	}
	
	public HomePage clickOnLogIn(String un,String pwd ){
		username.sendKeys(un);
		password.sendKeys(pwd);
		logInBtn.click();	
		
		return new HomePage();
	}
}
