package seleniumActivities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity_9_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriver driver = new FirefoxDriver();

	     //Open browser
	     driver.get("https://training-support.net/selenium/selects");
	     
	     // locate the dropdown WebElement on the page
	     WebElement selectObj = driver.findElement(By.id("single-select"));
	        
	     // create a new Select Class Object
	     Select s = new Select(selectObj);
	     
	     // Select the second option using selectByVisibleText()
	     s.selectByVisibleText("Option 2");
	     
	     //Select the third option using selectByIndex()
	     s.selectByIndex(3);
	     
	     //Select the fourth option using selectByValue()
	     s.selectByValue("4");
	     
	     //get all the options in the dropdown and print them one by one.
	     List<WebElement> options = s.getOptions();
	     
	     for ( WebElement option : options) {
	    	 
	    	 System.out.println(option.getText());
	     }
	     
	     driver.close();
	     
	}

}
