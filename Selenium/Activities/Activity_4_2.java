package seleniumActivities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_4_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
	    // open the website link on browser
	    driver.get("https://www.training-support.net/selenium/simple-form");
		
		// Print the title of the Page
		System.out.println("The Title of the Page is : " + driver.getTitle());
		
		// To find all the input fields on the page using xpath and fill the details 	
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Gaurav");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Kumar");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("gkumar20@in.ibm.com");
		driver.findElement(By.xpath("//input[@id='number']")).sendKeys("9818064162");
		
		
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@value='submit']")).click();
		
		Thread.sleep(2000);
		
		//Click OK on the alert page
		driver.switchTo().alert().accept();				 	
	    
		driver.close();
		
		
	}

}
