package seleniumActivities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_4_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
	    // open the website link on browser
	    driver.get("https://www.training-support.net/selenium/target-practice");
		
		// Print the title of the Page
		System.out.println("The Title of the Page is : " + driver.getTitle());
		
		// To find the third-header 	
		String text = driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
		System.out.println("The text of the third header is : " + text);
		
		// To find the color of the fifth-header 
		String color = driver.findElement(By.xpath("//h5[contains(text(),'Fifth header')]")).getCssValue("color");
		System.out.println("The color of the Fifth header is : " + color);
	
		// To find the class attributes of the Violet button 
		String classAttr = driver.findElement(By.xpath("//button[contains(text(),'Violet')]")).getAttribute("class");
		System.out.println("The class Attributes of the Violet is : " + classAttr);
		
		// To find the text of the Grey Button 
		String textGrey = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]")).getText();
		System.out.println("The text of the Grey Button is : " + textGrey);
				
		
	}

}
