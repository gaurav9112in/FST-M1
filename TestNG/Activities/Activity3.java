package TestNGActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
WebDriver driver;
    
    @BeforeClass
    public void openBrowser() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
            
        //Open the browser
        driver.get("https://www.training-support.net/selenium/login-form");
    }
    

    @Test
    public void testCase1() {
    	
        // locate the input fields - username and password and Login button
        WebElement username = driver.findElement(By.cssSelector("input#username"));
        WebElement password = driver.findElement(By.cssSelector("input#password"));
        WebElement login = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        
        
        //Enter the credentials - admin and password click the "Log in" button.
        username.sendKeys("admin");
        password.sendKeys("password");
        login.click();
        
        // Read the confirmation message and make and assertion to check if the correct message has been printed
        String Actual_message = driver.findElement(By.cssSelector("div#action-confirmation")).getText();
        String Expected_message = "Welcome Back, admin";
        
        System.out.println("The message printed on the screen is : " + Actual_message );
        
        Assert.assertEquals(Actual_message, Expected_message);
    }
    
    @AfterTest
    public void closeBrowser() {
        //Close the browser
        driver.close();
    }

}