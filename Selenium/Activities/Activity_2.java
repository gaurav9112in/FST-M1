package seleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net");
		System.out.println("The Title of the Page is : " + driver.getTitle());
		
		// To find the "About Us" link using ID locator
		WebElement getLinkById =  driver.findElement(By.id("about-link"));
		System.out.println("The Text of the Link is : " + getLinkById.getText());
		
		// To find the "About Us" link using ClassName locator
		WebElement getLinkByClassName =  driver.findElement(By.className("ui"));
		System.out.println("The Text of the Link is : " + getLinkByClassName.getText());
		
		// To find the "About Us" link using LinkText locator
		WebElement getLinkByLinkText =  driver.findElement(By.linkText("About Us"));
		System.out.println("The Text of the Link is : " + getLinkByLinkText.getText());
	
		// To find the "About Us" link using CssSelector locator
		WebElement getLinkByCss =  driver.findElement(By.cssSelector("#about-link"));
		System.out.println("The Text of the Link is : " + getLinkByCss.getText());
		
		// To find the "About Us" link using Xpath locator
		WebElement getLinkByXpath =  driver.findElement(By.xpath("//a[@id='about-link']"));
		System.out.println("The Text of the Link is : " + getLinkByXpath.getText());
		
		driver.close();
		
	}

}
