package seleniumActivities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_11_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        //Open browser
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        
        // Print the title of the Page
        System.out.println("The Title of the Page is : " + driver.getTitle());
        
        //Click the button to open a confirm alert
        driver.findElement(By.id("confirm")).click();

        //Switch to alert window
        Alert confirmAlert = driver.switchTo().alert();

        //Get text in the alert box and print it
        String alertText = confirmAlert.getText();
        System.out.println("Alert text is: " + alertText);

        //Close the alert box with 'OK'
        confirmAlert.accept();
        
        //Click the button again to open a confirm alert
        driver.findElement(By.id("confirm")).click();
           
        //Close the alert box with 'Cancel' option
        confirmAlert.dismiss();
        
        //Close the Browser
        driver.close();
    }
}

