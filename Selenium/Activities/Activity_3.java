package seleniumActivities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		driver.get("https://training-support.net/selenium/simple-form");
		System.out.println("The Title of the Page is : " + driver.getTitle());
		
		
		driver.findElement(By.id("firstName")).sendKeys("Gaurav");
		driver.findElement(By.id("lastName")).sendKeys("Kumar");
		
		driver.findElement(By.id("email")).sendKeys("gkumar20@in.ibm.com");
		driver.findElement(By.id("number")).sendKeys("9818064162");
		
		
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@value='submit']")).click();
		
		driver.switchTo().alert().accept();
				 	
	    driver.close();

	    
	}

}
