package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage {
	
	WebDriver driver;
	
	//creating constructor
	public Landingpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//locators //objects
	@FindBy(xpath="//a[text()='My Account']")
	WebElement myAccountDropdown;
	
	@FindBy(linkText="Login")
	WebElement loginOption;
	
	public void myAccountDropdown() {
		
		
		myAccountDropdown.click();
	}
	
	public void loginOption() {
		
		loginOption.click();
		
	}

}
