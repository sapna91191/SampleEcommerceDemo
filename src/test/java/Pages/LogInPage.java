package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.PropertyCall;

public class LogInPage{

	public WebDriver driver;
	
		
	public LogInPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='email']")
	WebElement userName;
	@FindBy(xpath="//input[@id='passwd']")
	WebElement Password;
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement logInButton;
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement signIn;
	
	public void clickSignIn()
	{
		signIn.click();
	}
	public void enterUserName(String userNameProp)
	{
		userName.sendKeys(userNameProp);
	}
	
	public void enterpassword(String PasswordProp){
		Password.sendKeys(PasswordProp);
	}
	
	public void signIn()
	{
		logInButton.click();
	}
}
