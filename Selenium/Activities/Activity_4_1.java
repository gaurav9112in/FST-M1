package seleniumActivities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_4_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
	    // open the website link on browser
	    driver.get("https://www.training-support.net");
		
		// Print the title of the Page
		System.out.println("The Title of the Page is : " + driver.getTitle());
		
		// Click on the Link 'About Us'
		driver.findElement(By.xpath("//a[@id='about-link']")).click();
		
		// Print the title of the new Page 
		System.out.println("The Title of the Page is : " + driver.getTitle());
		
		
	}

}
