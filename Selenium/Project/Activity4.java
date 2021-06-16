package activities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

// Activity 4 : Add a new employee
public class Activity4 {

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
	
	// Add an employee and their details to the site
	@Test
	public void addEmployeeDetails()
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
		
		// Find the PIM option in the menu and click it.
		Actions action = new Actions(driver);
		WebElement pimButton = driver.findElement(By.id("menu_pim_viewPimModule"));
		action.moveToElement(pimButton).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewEmployeeList")));
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		
		// Click the Add button
		WebElement addButton = driver.findElement(By.id("btnAdd"));
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
		
		// Fill in the required fields
		
		driver.findElement(By.id("firstName")).sendKeys("Gaurav");
		driver.findElement(By.id("lastName")).sendKeys("Kumar");
		
		// Click on Save Button
		driver.findElement(By.id("btnSave")).click();
		
		// Navigate back to the PIM page
		// Find the PIM option in the menu and click it.
		WebElement pimButton2 = driver.findElement(By.id("menu_pim_viewPimModule"));
		action.moveToElement(pimButton2).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewEmployeeList")));
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		
		// Enter the employee name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("empsearch_employee_name_empName")));         
		driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Gaurav Kumar" + Keys.TAB);
		
		// Click on Search Button
		
		driver.findElement(By.id("searchBtn")).click();
		
		// Verify the Employee Details
		String firstname = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]/a")).getText();
		String lastname = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[4]/a")).getText();

		Assert.assertEquals(firstname, "Gaurav");
		Assert.assertEquals(lastname, "Kumar");

	}
	
	
	@AfterMethod
	public void closeBrowser()
	{
		//Close the Browser
		driver.close();
	}
	
}	