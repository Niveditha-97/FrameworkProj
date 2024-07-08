package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver driver ;
	
	public Loginpage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="input-email")
	WebElement emailAddressTextField;
	
	@FindBy(id="input-password")
	WebElement passwordField;

	@FindBy(css="input[value='Login']")
	WebElement loginButton;
	
	public WebElement emailAddressTextField() 
	{
		
		return emailAddressTextField;
		
	}
	
	public WebElement passwordField() {
		
		return passwordField;
		
	}
	
	public void loginButton() {
		
		loginButton.click();
	}
	
}
