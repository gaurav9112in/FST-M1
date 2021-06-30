package TestNGActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
	
  WebDriver driver = new FirefoxDriver();	
  @BeforeMethod	
  public void openBrowser()
  {
	  

      //Open browser
      driver.get("https://www.training-support.net");	  
  }
	
  //Verify the website title	
  @Test
  public void first() {
	
	// print the title of the page
	System.out.println("The Title of the Page is : " + driver.getTitle());
	
	//Assert the title of the page	
	Assert.assertEquals("Training Support", driver.getTitle());
	
	// Click on the button 'About Us'
	WebElement getLinkById =  driver.findElement(By.id("about-link"));
	getLinkById.click();
	
	// print the title of the new page
	System.out.println("The new Title of the Page is : " + driver.getTitle());
	
	//Assert the title of the new page
	Assert.assertEquals(driver.getTitle(), "About Training Support");
	
  }
  
  @AfterMethod
  public void closeBrowser()
  {
	  driver.close();
  }
  
  
}
