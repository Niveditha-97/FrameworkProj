package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobject.Accountpage;
import pageobject.Landingpage;
import pageobject.Loginpage;
import resources.Base;

public class LoginTest extends Base {   // to login we need to open browser n max so extending it form base class as parent to this
	
	WebDriver driver;
	//Convert this method to testng to execute
	@Test(dataProvider ="getLoginData" )
	public void login(String email,String password,String expectedResult) throws IOException, InterruptedException 
	{
		//initializedriver(); throws io exception
	 
		//WebDriver driver = initializedriver();  // since it returns driver it has to be stored and since from parent directly called
		//prop.getProperty("url");  // called as before method
		
		//to use methods on eleemnts from tht page create a object n access
		Landingpage lp = new Landingpage(driver);
		lp.myAccountDropdown();
		lp.loginOption();
		Thread.sleep(3000);
		
		Loginpage lop= new Loginpage(driver);
		lop.emailAddressTextField().sendKeys(email);
		lop.passwordField().sendKeys(password);
		lop.loginButton();
		
		Accountpage ap = new Accountpage(driver);
		
        String actualResult = null;
        
try {
			
			if(ap.editYourAccountInformation().isDisplayed()) {
			   actualResult = "Success";
				Assert.assertTrue(ap.editYourAccountInformation().isDisplayed());
			}
			
		}catch(Exception e) {
			
			actualResult = "Failure";
			
		}

		
		
		//ap.editYourAccountInformation().isDisplayed();

		Assert.assertEquals(actualResult,expectedResult);
		
		}
	@BeforeMethod
	public void openApplication() throws IOException {
		
		driver = initializedriver();//driver is made global so can be used now
		driver.get(prop.getProperty("url"));// can be changed again n again so to avoid hardcode put in properties file
		
	}
	

	@AfterMethod
	public void teardown()
	{
		driver.close();  // driver is made global so can be used now
	}
	
	@DataProvider
public Object[][] getLoginData()
{
Object[][] data = {{"arun.selenium@gmail.com","Second@123","Failure"},{"dummy@test.com","1234","Failure"}};
		
		return data;
		
}
	
	
	
	
	
	
	

}
