package seleniumActivities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_7_2 {

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
		List<WebElement> userList = driver.findElements(By.xpath("//div[@id='dynamic-attributes-form']/div/div[1]/input"));
		WebElement username = userList.get(1);
		
		List<WebElement> pwdList = driver.findElements(By.xpath("//div[@id='dynamic-attributes-form']/div/div[2]/input"));
		WebElement password = pwdList.get(1);
		
		WebElement confirmPassword = driver.findElement(By.xpath("//div[@id='dynamic-attributes-form']/div/div[3]/input")); 
		WebElement email = driver.findElement(By.xpath("//div[@id='dynamic-attributes-form']/div/div[4]/input")); 
		
		WebElement signUpButton = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));
		WebElement message = driver.findElement(By.xpath("//div[@id='action-confirmation']"));
		
		
		//Type in the credentials
		username.sendKeys("gaurav9112in");
		password.sendKeys("password");
		confirmPassword.sendKeys("password");
		email.sendKeys("gaurav9112in@yahoo.com");
		
		
		//Click on login
		signUpButton.click();
		
		//Wait for login message to appear
		wait.until(ExpectedConditions.textToBePresentInElement(message, "Thank you for registering, gaurav9112in"));
				
		//Print the login message
		System.out.println("The message is :" + message.getText());
				
		// Close the Browser
		driver.close();

	}

}
