package resources;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// Every test requires launching the browser hence in baseclass we initialized the driver
public class Base {
	
	WebDriver driver; // declared outside the method inside class so can be accessed by all methods //like int a later use a = 10;
	public Properties prop; // made global n public to access everywhere
	
	public WebDriver initializedriver() throws IOException
	{
		//String browsername = "Chrome";   // hardcoded value we are giving and based on that triggering the driver should be passed in method
		
		//Instead of harding the values we are taking browser from properties file - properties is a class so create a object of that n call the methods of that
		//Properties prop = new Properties(); 
		// properties prop cn be changed to prop = since properties is global - null pointer exception
		prop = new Properties();
		String propertiesPath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";// path is decoded here
		FileInputStream fis = new FileInputStream(propertiesPath); // here fileipstream object is created with properties path 
		prop.load(fis);  // loading the propertiesfile using load method of properties class - load requires input stream
		
		String browsername = prop.getProperty("browser"); 
		
		/*FileReader file = new FileReader(".//src//test//resources//config.properties"); // file reader object with file name to read data
		p = new Properties(); //creating object of properties class bcz putting properties p in class level
		p.load(file);  // loading file now*/

		if(browsername.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else 
		{
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();

		}
		
		/*switch(browsername.toLowerCase())
		{
		case "chrome":
			driver=new ChromeDriver();
			 break;
			case "edge" : 
			driver=new EdgeDriver(); 
			break;
			
		}*/ // using switch
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;      // return driver
	}
	
	
		
	/*	public void setup(String br)   // passing the browser from outside and using switch since multiple conditions and if not return without executing so return after default
		{
			switch(br.toLowerCase())
			{
			case "chrome" : 
			driver=new ChromeDriver();
			 break;
			case "edge" : 
			driver=new EdgeDriver(); 
			break;
			case "firefox":
			  driver=new FirefoxDriver();
			  break;
			default :
			 System.out.println("Invalid browser name.."); 
			 return;
		
		

	}
		}*/

}
