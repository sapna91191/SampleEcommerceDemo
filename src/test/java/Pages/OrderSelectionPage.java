package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderSelectionPage {
	

	public WebDriver driver;
	
	Actions actions;
	
	public OrderSelectionPage(WebDriver driver)
	{		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Faded Short Sleeve T-shirts']")
	WebElement imageHover;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement addToCart;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckout;

	@FindBy(xpath="(//span[contains(text(),'Proceed to checkout')])[2]")
	WebElement confirmCheckout;
	
	@FindBy(xpath="//input[@id='cgv']")
	WebElement agreecheckBox;
	
	@FindBy(xpath="//a[contains(text(),'Pay by bank')]")
	WebElement payOption1;
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	WebElement confirmOrder;
	
		
	@FindBy(xpath="//strong[contains(text(),'complete')]")
	WebElement orderCompletionText;
	
		
	public void addToCart()
	{
		actions=new Actions(driver);
		actions.moveToElement(imageHover).build().perform();
		actions.moveToElement(addToCart).click().perform();
	}
	
	public void proceed()
	{
		proceedToCheckout.click();
		confirmCheckout.click();
		actions.moveToElement(confirmCheckout).click().build().perform();
		agreecheckBox.click();
		actions.moveToElement(confirmCheckout).click().build().perform();
		payOption1.click();
		actions.moveToElement(confirmOrder).click().build().perform();
		Assert.assertEquals(orderCompletionText.getText(), "Your order on My Store is complete.");
	}
	
}
