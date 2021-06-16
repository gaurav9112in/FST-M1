package activities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Activity5 : Edit user information 
public class Activity5 {
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
	
	// Edit a user’s information
	@Test
	public void editUserInformation() throws InterruptedException
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
		
		
		if(driver.findElements(By.id("btnSave")).isEmpty())
		{
			Thread.sleep(5000);
			action.click(myInfoButton);
			
		}
		
		
		// Click the Edit button
		WebElement editButton = driver.findElement(By.id("btnSave"));
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
		editButton.click();
		
		// Fill in the required fields
		WebElement firstName = driver.findElement(By.id("personal_txtEmpFirstName"));
		WebElement lastName = driver.findElement(By.id("personal_txtEmpLastName"));
		WebElement gender = driver.findElement(By.id("personal_optGender_1"));
		WebElement nation = driver.findElement(By.id("personal_cmbNation"));
		Select nationality = new Select(nation);
		firstName.clear();
		lastName.clear();
		
		 // If male option is selected then click on female option else click on Male option
		if(gender.isSelected())
		{
			firstName.sendKeys("Elisa");
			lastName.sendKeys("Bacchi");
			driver.findElement(By.id("personal_optGender_2")).click(); 
			nationality.selectByVisibleText("Italian");
		}
		else
		{
			firstName.sendKeys("John");
			lastName.sendKeys("Doe");
			driver.findElement(By.id("personal_optGender_1")).click();  
			nationality.selectByVisibleText("Indian");		
		}
		
		// Click on Save Button
		driver.findElement(By.id("btnSave")).click();
				
	}
	
	
	@AfterMethod
	public void closeBrowser()
	{
		//Close the Browser
		driver.close();
	}
	
}	
	


