package pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement emailInputfield;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement passwordInputField;
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	public void enterUserEmail(String email)
	{
		emailInputfield.sendKeys(email);
	}
	public void enterUserPassword(String password)
	{
		passwordInputField.sendKeys(password);
	}
	public void clickSignInButton()
	{
		loginButton.click();
	}
	
}
