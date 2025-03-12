package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	WebDriver driver;

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "input-firstname")
	WebElement firstNameField;
	@FindBy(id = "input-lastname")
	WebElement lastNameField;
	@FindBy(id = "input-email")
	WebElement emailField;
	@FindBy(id = "input-telephone")
	WebElement telephoneField;
	@FindBy(id = "input-password")
	WebElement passwordField;
	@FindBy(id = "input-confirm")
	WebElement confirmPassword;
	@FindBy(name = "agree")
	WebElement pricavayLink;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement SelectContinueButton;
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement successMessage;
	
	public void enterFirstName(String fname)
	{
		firstNameField.sendKeys(fname);
	}
	public void enterLastName(String lname)
	{
		lastNameField.sendKeys(lname);
	}
	public void enterEmailId(String email)
	{
		emailField.sendKeys(email);
	}
	public void enterTelephoneNumber(String phone)
	{
		telephoneField.sendKeys(phone);
	}
	public void enterPassword(String pwd)
	{
		passwordField.sendKeys(pwd);
	}
	public void enterConfirmPassword(String confirmPwd)
	{
		confirmPassword.sendKeys(confirmPwd);
	}
	public void selectPrivacyLink()
	{
		pricavayLink.click();
	}
	public void selectContinueButton()
	{
		SelectContinueButton.click();
	}
	public String getConfirmationMessage()
	{
		try {
			return successMessage.getText();
		}catch (Exception e)
		{
			return(e.getMessage());
		}
	}

}
