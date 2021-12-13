package Tests;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import Generic.ExcelManager;
import Pages.HomePage;
import Pages.LogInPage;
import Pages.OrderSelectionPage;

public class TestCasesExecution extends BaseClass{
		
	@Test(priority=1)
	public void orderCreation() throws IOException
	{
		 System.out.println("into order creation");
		 propertyValuesFetch();
		 LogInPage objLogin=new LogInPage(driver);
		 objLogin.clickSignIn();
		 objLogin.enterUserName(userNameProp);
		 objLogin.enterpassword(PasswordProp);
		 objLogin.signIn();
		 HomePage objHome=new HomePage(driver);
		 objHome.MouseOverWomenSection();
		 objHome.clickTShirtSection();
		 OrderSelectionPage objOrder=new OrderSelectionPage(driver);
		 objOrder.addToCart();
		 objOrder.proceed();
		 	 
		 		 
	}
	
	@Test(dataProvider="logInCreds",dataProviderClass=Generic.InputData.class)
	public void logIn(String username,String password) throws IOException
	{
		 System.out.println("into login");
		 LogInPage objLogin=new LogInPage(driver);
		 objLogin.clickSignIn();
		 System.out.println(username);
		 objLogin.enterUserName(username);
		 objLogin.enterpassword(password);
		 objLogin.signIn();
		 HomePage objHome=new HomePage(driver);
		 objHome.ValidateHomePageTitle();
	}

}
