package pom.fb.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.fb.qa.base.TestBase;
import pom.fb.qa.pages.ContactsPage;
import pom.fb.qa.pages.HomePage;
import pom.fb.qa.pages.LoginPage;
import pom.fb.qa.util.Utili;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	Utili util;
	ContactsPage contactPage;
	
public ContactsPageTest()
{
	super();
}

@BeforeMethod
public void setUp() throws InterruptedException
{
	initialization();
	 loginPage=new LoginPage();
	 contactPage=new ContactsPage();
	 util=new Utili();
	 homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	 util.switchToFrame();
	 contactPage=homePage.verifyContactclick();
	 Thread.sleep(2000);
}

@Test(priority=1)
public void verifyContactsLabelTest()
{
	Assert.assertTrue(contactPage.verifyContactsLabel());
}
 
@Test(priority=2)
public void verifyContactListTest() throws InterruptedException
{
contactPage.verifyContactList();	
}
//


@AfterMethod
public void tearDown()
{
driver.close();
}

}

