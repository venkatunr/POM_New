package pom.fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.fb.qa.base.TestBase;
import pom.fb.qa.pages.HomePage;
import pom.fb.qa.pages.LoginPage;
import pom.fb.qa.util.Utili;

public class HomePageTest extends TestBase  
{
	LoginPage loginPage;
	HomePage homePage;
	Utili util;
	
	public HomePageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage=new LoginPage();	
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		util=new Utili();
	}
	
//	 @Test(priority=1)
//	 public void verifyHomePageTitleTest() 
//	 {
//		 String homePageTitle=homePage.verifyHomePageTitle();
//		 Assert.assertEquals(homePageTitle, "CRMPRO" );
//	 }
//	 
//	 @Test(priority=2)
//	 public void verfiyUserLoginNameTest()
//	 {
//		 util.switchToFrame();
//		 boolean name=homePage.verfiyUserLoginName();
//		 Assert.assertTrue(name);
//	 }
	 
	 
	@AfterMethod
	public void tearDown()
	{
	driver.close();
	}
}
