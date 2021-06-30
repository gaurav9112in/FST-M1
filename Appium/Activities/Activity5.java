package activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Activity5 {
	
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		
		
		DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel4Emulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.messaging");
        caps.setCapability("appActivity", ".ui.ConversationListActivity");
        caps.setCapability("noReset", true);
		
        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver,10);
	}  
	
	@Test
	public void sendMessage() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Click on New message button
		driver.findElement(MobileBy.AndroidUIAutomator("description(\"Start new conversation\")")).click();
	    
		// Locate the contact fields
		String contactBox = "resourceId(\"com.google.android.apps.messaging:id/recipient_text_view\")";	
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(contactBox))).click();
		
		// enter your own phone number to send a message  
		MobileElement contactNo = driver.findElement(MobileBy.AndroidUIAutomator(contactBox));
		contactNo.sendKeys("9818064162");	
		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		
		
		// Locate the message input field 
		String messageBox = "resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")";
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(messageBox))).click();				
		
		// Enter the message "Hello from Appium"
		MobileElement messageContent = driver.findElement(MobileBy.AndroidUIAutomator(messageBox));
		messageContent.sendKeys("Hello from Appium");
		
		// click on send button
		driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/send_message_button_icon\")")).click();	
		

        // Wait for message to show
        String messageLocator = "resourceId(\"com.google.android.apps.messaging:id/message_text\")";
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(messageLocator)));
 
        // Assertion
        String sentMessageText = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
        Assert.assertEquals(sentMessageText, "Hello from Appium");			
	   
	}
		    
	@AfterClass
	public void tearDown() {
	    driver.quit();
	}
	           
        
}
