package seleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_6_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver,5);
		
	    // open the website link on browser
	    driver.get("https://training-support.net/selenium/dynamic-controls");
	    
		// Print the title of the Page
		System.out.println("The Title of the Page is : " + driver.getTitle());
		
		// To find the checkbox on the page
		WebElement checkbox = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input"));
		WebElement toggleCheckBox = driver.findElement(By.xpath("//button[@id='toggleCheckbox']"));
		
		// Click on button remove checkbox
		toggleCheckBox.click();
		System.out.println("After Clicking on button remove Checkbox");
		
		//Wait till the checkbox disappears
		wait.until(ExpectedConditions.invisibilityOf(checkbox));
		
		// To check if the checkbox is visible or not
		System.out.println("Is the checkbox visible : " + checkbox.isDisplayed());
		
		// Click on button Add checkbox
		toggleCheckBox.click();
		System.out.println("After Clicking on button Add Checkbox");
		
		//Wait till the checkbox appears
		wait.until(ExpectedConditions.visibilityOf(checkbox));
		
		// To check if the checkbox is visible or not
		System.out.println("Is the checkbox visible : " + checkbox.isDisplayed());
	
		driver.close();

	}
}