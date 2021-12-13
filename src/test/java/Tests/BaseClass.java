package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Generic.PropertyCall;

public class BaseClass extends PropertyCall {

	public static WebDriver driver;
	
	@BeforeMethod
	public WebDriver LaunchBroser() throws IOException
	{
	System.out.println(System.getProperty("user.dir"));
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/java/Resources/chromedriver.exe");
	driver=new ChromeDriver();
	propertyValuesFetch();
	driver.get(baseURL);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    return driver;
  
	}
	
	@AfterMethod
	public void quit()
	{
		driver.close();
		driver.quit();
	}
}
