package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccoutsPage;
import testBase.BaseClass;
import utilities.dataProviders;

public class TC003_LoginWithTestData extends BaseClass {
	@Test(dataProvider = "LoginData", dataProviderClass = dataProviders.class)
	public void loginwithTestData(String userName, String password, String Result) {
		try {
			logger.info("***Data driven testing for valid and invalid login****");
			HomePage homepage = new HomePage(driver);
			LoginPage loginpage = new LoginPage(driver);
			MyAccoutsPage myaccountpage = new MyAccoutsPage(driver);

			homepage.clickonmyAccountLink();
			homepage.clikOnLoginLink();
			loginpage.enterUserEmail(userName);
			loginpage.enterUserPassword(password);
			loginpage.clickSignInButton();
			boolean targetPage = myaccountpage.myAccountLabelExist();

			// for valid input validation
			if (Result.equalsIgnoreCase("Valid")) {
				if (targetPage == true) {
					myaccountpage.logout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
			if (Result.equalsIgnoreCase("Invalid")) {
				if (targetPage == false) {
					myaccountpage.logout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("***Data driven testing for valid and invalid login completed****");

	}

}
