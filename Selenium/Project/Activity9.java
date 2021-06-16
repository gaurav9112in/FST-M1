package activities;

import java.util.List;
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

// Activity 9 : Retrieve emergency contacts
public class Activity9 {
	
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
	
	// Login and retrieve the emergency contacts for the user
	@Test
	public void retrieveContacts() throws InterruptedException
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
		
		// Find the MyInfo option in the menu and click it.
		Actions action = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewMyDetails")));
		WebElement myInfoButton = driver.findElement(By.id("menu_pim_viewMyDetails"));	
		action.moveToElement(myInfoButton).click(myInfoButton).build().perform();
		
		if(driver.findElements(By.xpath("//ul[@id='sidenav']/li[3]/a")).isEmpty())
		{
			Thread.sleep(5000);
			action.click(myInfoButton);
			
		}
		
		// find the Emergency Contacts option on the left side menu and click it
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='sidenav']/li[3]/a")));
		driver.findElement(By.xpath("//ul[@id='sidenav']/li[3]/a")).click();
		
		//Retrieve information about all the contacts listed in the table
		List<WebElement> listContacts = driver.findElements(By.xpath("//table[@id='emgcontact_list']/tbody/tr/td[4]")); 
		
		//Print all the information to the console
		System.out.println("The list of the Contact Numbers");
		for ( WebElement contact : listContacts )  
		{
			System.out.println(contact.getText());
		}
			
	}	
	
	@AfterMethod
	public void closeBrowser()
	{
		//Close the Browser
		driver.close();
	}
	
	
}
