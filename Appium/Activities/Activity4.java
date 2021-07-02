package activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity4 {
	
	AppiumDriver<MobileElement> driver = null;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		
	
		
		DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel4Emulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.contacts");
        caps.setCapability("appActivity", ".activities.PeopleActivity");
        caps.setCapability("noReset", true);
		
        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
	}     
	   @Test
	    public void addContact() {
		    
		    // Adding implicit wait condition
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    
		    // Click on Create New Contact
		    driver.findElementById("contact_name").click();
		    
		    
		    // Enter the FirstName, LastName and Phone Number
		    driver.findElement(MobileBy.AndroidUIAutomator("text(\"First name\")")).sendKeys("Gaurav");
		    driver.findElement(MobileBy.AndroidUIAutomator("text(\"Last name\")")).sendKeys("Kumar");
		    driver.findElement(MobileBy.AndroidUIAutomator("text(\"Phone\")")).sendKeys("9818064162");
		    
		    
	        //Click on Save Button
		    //wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("editor_menu_save_button")));
	        driver.findElementByXPath("//android.widget.Button[@text='SAVE']").click();
	        
	        // Get the ContactName 
	        String contactName = driver.findElementById("large_title").getText();
	        
	        // Assertion
	        Assert.assertEquals(contactName, "Gaurav Kumar");
	        
	    }
	    
	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	           
}
