package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

	public WebDriver driver;
	Actions a;

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//a[text()='Women']")
	WebElement womenSection;
	
	@FindBy(xpath="(//a[text()='T-shirts'])[1]")
	WebElement tShirtSection;
	
	public void MouseOverWomenSection()
	{
		a=new Actions(driver);
		a.moveToElement(womenSection).build().perform();
	}
	public void clickTShirtSection()
	{
		tShirtSection.click();
	}
	
	public void ValidateHomePageTitle()
	{
		Assert.assertEquals(driver.getTitle(),"My account - My Store");
	}
	
	
}
