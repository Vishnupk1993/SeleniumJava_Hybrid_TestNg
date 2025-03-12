package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_accountRegistration_Test extends BaseClass {
	
	
	
	@Test(groups = {"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("*****Starting Test case001*****");
		try {
		HomePage homepage = new HomePage(driver);
		AccountRegistrationPage accountRegistration = new AccountRegistrationPage(driver);
		
		homepage.clickonmyAccountLink();
		logger.info("*****Clicked on my account link*****");
		homepage.clickonregisterButton();
		logger.info("*****Customer Registration*****");
		accountRegistration.enterFirstName(randomString().toUpperCase());
		accountRegistration.enterLastName(randomString().toUpperCase());
		accountRegistration.enterEmailId(randomString()+"@gmail.com");
		accountRegistration.enterTelephoneNumber(randomNumber());
		
		String password=randomAlphaNumerals(); //storing password to a new variable since 2 password areas are there.
		accountRegistration.enterPassword(password);
		accountRegistration.enterConfirmPassword(password);
		accountRegistration.selectPrivacyLink();
		accountRegistration.selectContinueButton();
		logger.info("*****Clicked on continue button*****");
		String confimrationMessage=accountRegistration.getConfirmationMessage();
		Assert.assertEquals(confimrationMessage,"Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Test Failed...");
			logger.debug("Debug Logs..");
			Assert.fail();
		}
		logger.info("*****Finished executing Test-case001*****");
	}
	
}
