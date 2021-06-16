package activities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// Activity 6 : Verify that the “Directory” menu item is visible and clickable
public class Activity6 {	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void openBrowser()
	{
		//Open the Browser
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,10);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Navigate to 'http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login'
		driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
		
	}
	
	// Verify that the “Directory” menu item is visible and clickable
	@Test
	public void verifyDirectory()
	{
		
		// login with the credentials provided
		
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
		
		// Verify that the “Directory” menu item is visible and clickable
		Actions action = new Actions(driver);
		WebElement directoryButton = driver.findElement(By.id("menu_directory_viewDirectory"));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_directory_viewDirectory")));
		Assert.assertTrue(directoryButton.isDisplayed(), "Directory button is not visible");

		// Click on Directory
		action.moveToElement(directoryButton).click(directoryButton).build().perform();
		
		// Verify the heading of the page matches “Search Directory”.
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='content']/div/div/h1"),"Search Directory"));
		String message = driver.findElement(By.xpath("//div[@id='content']/div/div/h1")).getText();
		Assert.assertEquals(message, "Search Directory");
		
	}	
	
	@AfterMethod
	public void closeBrowser()
	{
		//Close the Browser
		driver.close();
	}
	
}	


