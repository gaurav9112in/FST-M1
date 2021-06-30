package seleniumActivities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_5_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
	    // open the website link on browser
	    driver.get("https://training-support.net/selenium/dynamic-controls");
	    
		// Print the title of the Page
		System.out.println("The Title of the Page is : " + driver.getTitle());
		
		// To find the checkbox on the page
		WebElement checkbox = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input"));
		
		// To check if the checkbox is visible or not
		System.out.println("Is the checkbox visible : " + checkbox.isDisplayed());
		
		
		// Click on button remove checkbox
		driver.findElement(By.xpath("//button[@id='toggleCheckbox']")).click();
		System.out.println("After Clicking on button remove Checkbox");
		
		// To check if the checkbox is visible or not
		System.out.println("Is the checkbox visible : " + checkbox.isDisplayed());
	
		driver.close();

	}
}
