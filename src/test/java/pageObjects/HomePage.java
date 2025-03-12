package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement myAccountLink;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Register']")
	WebElement registerLink;
	@FindBy(xpath="//li//a[text()='Login']")
	WebElement loginLink;
	
	public void clickonmyAccountLink()
	{
		myAccountLink.click();
	}
	public void clickonregisterButton()
	{
		registerLink.click();
	}
	public void clikOnLoginLink()
	{
		loginLink.click();
	}
	

}
