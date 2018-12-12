package pom.fb.qa.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pom.fb.qa.base.TestBase;

public class LoginPage extends TestBase 
{
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@alt='free crm logo']")
	WebElement crmLogo;
	
	@FindBy(xpath="//font[text()='Sign Up']")
	WebElement signupBtn;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav navbar-right']//li//a")
	List<WebElement> headerLinks;
	
	@FindBy(xpath="//i[@class='fa fa-chevron-right']")
	WebElement carousalRight;
    
	@FindBy(xpath="//i[@class='fa fa-chevron-left']")
	WebElement carousalLeft;
	
	@FindBy(xpath="//a[text()='Privacy Policy']")
	WebElement privacyPolicy;
  	
	@FindBy(xpath="//a[text()='Terms & Conditions']")
	WebElement termsAndConditions;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyCrmLogo()
	{
    return crmLogo.isDisplayed();
	}
	
	public List<String> validateHeaderLinks()
	{
		List<WebElement> headerLinks=driver.findElements(By.xpath("//ul[@class='nav navbar-nav navbar-right']//li//a"));
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0;i<headerLinks.size();i++)
		{
			String val = headerLinks.get(i).getText();
			list.add(val);
		}
		return list;
	}
	
	public boolean carousalControlRight()
	{
		return carousalRight.isDisplayed();
	}
	
	public boolean carousalControlLeft()
	{
	return carousalLeft.isDisplayed();
	}
 
	public void carousalClick()
	{
		List<WebElement> text=driver.findElements(By.xpath("//div[@class='carousel-inner']//div//h1"));
		for(int i=0;i<text.size();i++)
		{	
		     carousalRight.click();
		}
	}

	public void carousalClickLeft()
	{
		List<WebElement> text=driver.findElements(By.xpath("//div[@class='carousel-inner']//div//h1"));
		for(int i=text.size()-1;i>=0;i--)
		{	
			carousalLeft.click();
		}
	}
	
	public void signUp() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		boolean invisible=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
		if(invisible)
		{
			List<WebElement> list=driver.findElements(By.xpath("//div[@class='col-md-3 col-sm-6 margin']"));
			for(int i=1;i<=list.size();i++)
			{
			WebElement ele=refreshObject(By.xpath("//div[@class='col-md-3 col-sm-6 margin']["+i+"]//a"));
			ele.click();
 	         Thread.sleep(1000);
	         driver.navigate().back();
	         Thread.sleep(1000);
			}
		} 
	}
	
	public static WebElement refreshObject(By locator)
	{
		try {
			return driver.findElement(locator);
		} catch (StaleElementReferenceException e) 
		{
			return refreshObject(locator);
		}
	}
	
	
	public PrivacyAggrement verifyPrivacyPolicyLink()
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		boolean invisible=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
		if(invisible)
		{
			privacyPolicy.click();	
		}
        return new PrivacyAggrement();
	}
	
	public TermsAndConditions termsAndConditionsLink()
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		boolean invisible=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
		if(invisible)
		{
			termsAndConditions.click();	
		}
        return new TermsAndConditions();
	}
	
	public void verifyAllLinksAndImage() throws MalformedURLException, IOException
	{
		List<WebElement> linksList=driver.findElements(By.tagName("a"));
		linksList.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println(linksList.size());
		
		List<WebElement> activeLinks=new ArrayList<WebElement>();
		for(int i=0;i<linksList.size();i++)
		{
			System.out.println(linksList.get(i).getAttribute("href"));
		if(linksList.get(i).getAttribute("href") !=null)
		{
		activeLinks.add(linksList.get(i));
		}
		}
		System.out.println(activeLinks.size());
		
		for(int j=0;j<activeLinks.size();j++)
		{
			HttpURLConnection connection=(HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response=connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href")+ "---->"+ response);
		}
	}
	
	public HomePage login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		WebDriverWait wait=new WebDriverWait(driver,20);
		boolean invisible=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
        if(invisible)
        {
		loginBtn.click();
        }
		return new HomePage();
	}
}

