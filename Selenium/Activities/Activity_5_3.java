package seleniumActivities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_5_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
	    // open the website link on browser
	    driver.get("https://training-support.net/selenium/dynamic-controls");
	    
		// Print the title of the Page
		System.out.println("The Title of the Page is : " + driver.getTitle());
		
		// To find the text field on the page
		WebElement inputBox = driver.findElement(By.xpath("//input[@id='input-text']"));
		
		// To check if the input box is enabled or not
		System.out.println("Is the input box enabled : " + inputBox.isEnabled());
				
		// Click on button Enable Input
		driver.findElement(By.xpath("//button[@id='toggleInput']")).click();
		System.out.println("After Clicking on button Enable Input");
				
		// To check if the input box is enabled or not
		System.out.println("Is the input box enabled : " + inputBox.isEnabled());
		
		driver.close();
	}
}


