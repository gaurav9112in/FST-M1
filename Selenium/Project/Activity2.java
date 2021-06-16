package activities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// Activity 2 : Get the url of the header image
public class Activity2 {
	
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
	
	
	// Print the url of the header image to the console
	@Test
	public void printURLHeader()
	{
		
		//get the Header image
		String getURLHeader = driver.findElement(By.xpath("//div[@id='divLogo']/img")).getAttribute("src");
		
		//Print the URL of Header Image on Console
		System.out.println("The URL of the Header Image is " + getURLHeader);
			
	}
	
	
	@AfterMethod
	public void closeBrowser()
	{
		//Close the Browser
		driver.close();
	}
	
}


