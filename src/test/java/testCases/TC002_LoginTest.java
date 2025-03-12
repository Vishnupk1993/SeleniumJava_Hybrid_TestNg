package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccoutsPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups= {"Sanity","Master"})
	public void verify_Login()
	{
		try {
		logger.info("***user logging in to the application***");
		HomePage homepage= new HomePage(driver);
		LoginPage loginpage= new LoginPage(driver);
		MyAccoutsPage myaccountpage =new MyAccoutsPage(driver);
		
		homepage.clickonmyAccountLink();
		homepage.clikOnLoginLink();
		loginpage.enterUserEmail(property.getProperty("email"));
		loginpage.enterUserPassword(property.getProperty("password"));
		loginpage.clickSignInButton();
		boolean targetPage=myaccountpage.myAccountLabelExist();
		Assert.assertTrue(targetPage);
		logger.info("*****finished TC002-LoginTest*****");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
	}

}
