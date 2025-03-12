package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccoutsPage extends BasePage {

	public MyAccoutsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement myAccountLabel;
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	WebElement logutLink;
	public boolean myAccountLabelExist()
	{
		try
		{
			
		
		return (myAccountLabel.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	public void logout()
	{
		logutLink.click();
	}
	

}
