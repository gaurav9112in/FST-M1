package activities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// Activity 1 : Verify the website title
public class Activity1 {
	
	WebDriver driver;
	//WebDriverWait wait;
	
	@BeforeMethod
	public void openBrowser()
	{
		//Open the Browser
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
		//Navigate to 'http://alchemy.hguy.co/orangehrm'
		driver.get("http://alchemy.hguy.co/orangehrm");		
	}
	
	
	// Read the title of the website and verify the text
	@Test
	public void verifyTitle()
	{
		//get the title
		String title = driver.getTitle();
		System.out.println("The title of the Page is :" + title);
		
		//verify title matches “OrangeHRM” exactly
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	
	@AfterMethod
	public void closeBrowser()
	{
		//Close the Browser
		driver.close();
	}
	
}
