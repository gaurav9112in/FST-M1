package seleniumActivities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_7_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,10);
		
	    // open the website link on browser
	    driver.get("https://training-support.net/selenium/dynamic-attributes");
	    
		// Print the title of the Page
		System.out.println("The Title of the Page is : " + driver.getTitle());
		
		//Find the username and password input fields
		WebElement username = driver.findElement(By.xpath("//div[@id='dynamic-attributes-form']/div/div[1]/input"));
		WebElement password = driver.findElement(By.xpath("//div[@id='dynamic-attributes-form']/div/div[2]/input"));
		WebElement login = driver.findElement(By.xpath("//div[@id='dynamic-attributes-form']/div/button"));
		WebElement message = driver.findElement(By.xpath("//div[@id='action-confirmation']"));
		
		
		//Type in the credentials
		username.sendKeys("admin");
		password.sendKeys("password");
		
		//Click on login
		login.click();
		
		//Wait for login message to appear
		wait.until(ExpectedConditions.textToBePresentInElement(message, "Welcome Back, admin"));
		
		//Print the login message
		System.out.println("The login message is :" + message.getText());
		
		// Close the Browser
		driver.close();
	}

}
