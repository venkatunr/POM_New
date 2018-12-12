package pom.fb.qa.testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.fb.qa.base.TestBase;
import pom.fb.qa.pages.LoginPage;
import pom.fb.qa.pages.SignupPage;

public class LoginTest extends TestBase{
	LoginPage loginPage;
	SignupPage signupPage;
	
public LoginTest(){
	super();
}

@BeforeMethod
public void setUP()
{
	initialization();
	loginPage=new LoginPage();
}

@Test(priority=1)
public void validateTitleTest()
{
	String title=loginPage.validateTitle();
	Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
}

@Test(priority=2)
public void verifyCrmLogoTest()
{
	boolean flag=loginPage.verifyCrmLogo();
	Assert.assertTrue(flag);
}

@Test(priority=3)
public void verifyHeaderLinksTest()
{
List<String> value =loginPage.validateHeaderLinks();	
Assert.assertEquals(value.get(0), "Features");
Assert.assertEquals(value.get(1), "Sign Up");
Assert.assertEquals(value.get(2), "Pricing");
Assert.assertEquals(value.get(3), "Customers");
Assert.assertEquals(value.get(4), "Contact");
Assert.assertEquals(value.get(5), "Support");
}
	
@Test(priority=4)
public void carousalControlRightTest(){
	loginPage.carousalControlRight();
}
@Test(priority=5)
public void carousalControlLeftTest(){
	loginPage.carousalControlLeft();
}

@Test(priority=6)
public void carousalClickTest() throws InterruptedException
{
	loginPage.carousalClick();
	
}

@Test(priority=7)
public void carousalClickLeftTest() throws InterruptedException
{
	loginPage.carousalClickLeft();
		
}

@Test(priority=8)
public void signUpTest() throws InterruptedException
{
	loginPage.signUp();
}

@Test(priority=9)
public void verifyPrivacyPolicyLinkTest()
{
	loginPage.verifyPrivacyPolicyLink();
}
@Test(priority=10)
public void termsAndConditionsLinkTest(){
	loginPage.termsAndConditionsLink();
}

//@Test(priority=1)
//public void verifyAllLinksAndImageTest() throws MalformedURLException, IOException{
//	loginPage.verifyAllLinksAndImage();	
//}

@AfterMethod
public void tearDown() throws InterruptedException
{
	driver.quit();
}
}
