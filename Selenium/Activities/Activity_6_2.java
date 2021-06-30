package seleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_6_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver,10);
		
	    // open the website link on browser
	    driver.get("https://training-support.net/selenium/ajax");
	    
		// Print the title of the Page
		System.out.println("The Title of the Page is : " + driver.getTitle());
		
		//Find and click the "Change content" button on the page
		driver.findElement(By.xpath("//button[contains(text(),'Change Content')]")).click();
		
		// Wait for the text to say "HELLO!"
		WebElement ajaxContent1 = driver.findElement(By.xpath("//div[@id='ajax-content']/h1"));
		wait.until(ExpectedConditions.textToBePresentInElement(ajaxContent1,"HELLO!"));
		
		// Print the message that appears on the page
		System.out.println("The message printed on the Page is : " + ajaxContent1.getText());
		
		
		// Wait for the text to say "I'm late!"
		WebElement ajaxContent2 = driver.findElement(By.xpath("//div[@id='ajax-content']"));
		wait.until(ExpectedConditions.textToBePresentInElement(ajaxContent2, "I'm late!"));
				
		// Print the message that appears on the page
		System.out.println("The message printed on the Page is : " + ajaxContent2.getText());
				
	}
}