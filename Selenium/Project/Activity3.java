package activities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// Activity 3 : Logging into the site
public class Activity3 {
	
	WebDriver driver;
	
	@BeforeMethod
	public void openBrowser()
	{
		//Open the Browser
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Navigate to 'http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login'
		driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
		
	}
	
	
	// login with the credentials provided
	@Test
	public void loginHomePage()
	{
		
		// Enter the username as 'orange'
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		
		// Enter the password as 'orangepassword123'
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		
		//Click on Login
		driver.findElement(By.id("btnLogin")).click();
			
		//Verify that the homepage has opened 
		String welcomeMsg = driver.findElement(By.id("welcome")).getText();
		System.out.println("The Welcome message on the Homepage is :" + welcomeMsg);
		Assert.assertTrue(welcomeMsg.matches("Welcome.*"));
		
	}
	
	
	@AfterMethod
	public void closeBrowser()
	{
		//Close the Browser
		driver.close();
	}
	
}	


