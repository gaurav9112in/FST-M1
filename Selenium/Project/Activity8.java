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

// Activity 8 : Applying for a leave
public class Activity8 {
	
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
	
	// Login and apply for a leave on the HRM site
	@Test
	public void apply4Leave() throws InterruptedException
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
		
		// Click on My Leave option
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[4]/div/a")));
		
		WebElement applyleaveOption = driver.findElement(By.xpath("//div[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[4]/div/a"));
		
		Actions action = new Actions(driver);
		action.moveToElement(applyleaveOption).click(applyleaveOption).build().perform();
		
		
		
		// Select leave type and duration of the leave
		WebElement leaveObject  = driver.findElement(By.id("applyleave_txtLeaveType"));
		Select leaveType = new Select(leaveObject);
		leaveType.selectByValue("1");
		
		WebElement fromDate = driver.findElement(By.id("applyleave_txtFromDate"));
		fromDate.clear();
		fromDate.sendKeys("2021-06-14");
		
		WebElement toDate = driver.findElement(By.id("applyleave_txtToDate"));
		toDate.clear();
		toDate.sendKeys("2021-06-18");
		
		driver.findElement(By.id("applyleave_txtComment")).sendKeys("Selenium Project Activity");	
		
		// Click on Apply button
		driver.findElement(By.id("applyBtn")).click();
		
		// Click on MyLeave option
		driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
		
		// Check the status of the Leave 
		String statusLeave = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[6]/a")).getText();
		System.out.println("The status of the Leave applied is :" + statusLeave );
		
	}	
	
	@AfterMethod
	public void closeBrowser()
	{
		//Close the Browser
		driver.close();
	}

}
