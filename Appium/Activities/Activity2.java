package activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2 {
	
	AppiumDriver<MobileElement> driver = null;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
				
		DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel4Emulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);
		
        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        
	}   	
	
	@Test
	public void getTitle() {
		
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
	 driver.get("https://www.training-support.net/");	
		 
	 //driver.findElementById("infobar_close_button").click();
	 
	 // get the Title of the Page and Print on console	
	 String pageTitle = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
	 
     System.out.println("The Title of the Page is : " + pageTitle );
     
     // Click on About Us button
     driver.findElementByXPath("//android.view.View[@text='About Us']").click();
     
     // get the Title of the new Page and Print on console	
  	 String newPageTitle = driver.findElementByXPath("//android.view.View[@text='About Us']").getText();
     System.out.println("The Title of the Page is : " + newPageTitle );
         
	}
	
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
