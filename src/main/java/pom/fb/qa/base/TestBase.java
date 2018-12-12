package pom.fb.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		try {
			prop =new Properties();
			FileInputStream ip=new FileInputStream("D:\\POM\\POM\\src\\main\\java\\pom\\fb\\qa\\config\\config.properties");
			prop.load(ip);
		} 
		catch (FileNotFoundException e) {
		     e.printStackTrace();//ITs help to diagnosing an exceptions where it is occured.(printstackTrace() method)
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		 if(browserName.equalsIgnoreCase("firefox"))
		  {			
	   	   System.setProperty("webdriver.gecko.driver","D:\\POM\\POM\\drivers\\geckodriver_64bit.exe");
			driver =new FirefoxDriver();
		  }
		
		   else if(browserName.equalsIgnoreCase("chrome"))
	       {
		   String exePath = "D:\\POM\\POM\\drivers\\chromedriver.exe";
		   System.setProperty("webdriver.chrome.driver",exePath);
		   driver =new ChromeDriver();
	       }  
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
}
