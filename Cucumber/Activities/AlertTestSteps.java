package stepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AlertTestSteps {
	
	WebDriver driver;
	WebDriverWait wait;
	Alert alert;
	
	@Given("^User is on the page$")
	public void openBrowser() throws Throwable {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,5);
		
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		
	}
	
	@When("^User clicks the Simple Alert button$")
	public void clickSimpleAlert() throws Throwable
	{
		WebElement simpleAlert = driver.findElement(By.id("simple"));
		simpleAlert.click();
	}
	
	@When("^User clicks the Confirm Alert button$")
	public void clickConfirmAlert() throws Throwable
	{
		WebElement confirmAlert = driver.findElement(By.id("confirm"));
		confirmAlert.click();
	}
	
	@When("^User clicks the Prompt Alert button$")
	public void clickPromptAlert() throws Throwable
	{
		WebElement promptAlert = driver.findElement(By.id("prompt"));
		promptAlert.click();
	}
	
	@Then("^Alert opens$")
	public void switchToAlert() throws Throwable
	{
		alert = driver.switchTo().alert();
		
	}
	
	@And("^Read the text from it and print it$")
	public void readtext() throws Throwable
	{
		//String text = alert.getText();
		System.out.println("THe text on the Alert is : " + alert.getText());
	}
	
	@And("^Close the alert$") 
	public void closeAlert() throws Throwable
	{
		alert.accept();
	}
	
	@And("^Close the alert with Cancel$")
	public void closeAlertcancel() throws Throwable
	{
		alert.dismiss();
	}
	
	@And("^Read the result text$")
	public void readResultText() throws Throwable
	{
		System.out.println("Read the result text");
	}
	
	@And("^Write a custom message in it$")
	public void writeText() throws Throwable
	{
		alert.sendKeys("Cucumber Activity 3");
	}
	
	 @And("^Close Browser$") public void closeBrowser() throws Throwable {
	  driver.close(); }
	 	 
}
