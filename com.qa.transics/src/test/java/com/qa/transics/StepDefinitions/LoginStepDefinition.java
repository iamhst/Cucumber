package com.qa.transics.StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginStepDefinition {

	WebDriver driver;

	@Given("^User is on My Transics login page$")
	public void User_is_on_My_Transics_login_page() {
		System.out.println("User_is_on_My_Transics_login_page");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/executables/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
	}

	@And("^Tilte of the page is myTransics$")
	public void Tilte_of_the_page_is_myTransics() {
		System.out.println("Tilte_of_the_page_is_myTransics");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Facebook – log in or sign up", title);

	}
	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void User_enters_username_and_password(String username, String password) {
		System.out.println("User_enters_username_and_password");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
	}
	@When("^User enters username and password$")
	public void User_enters_username_and_password() {
		System.out.println("User_enters_username_and_password");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("iamhst@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Deepak@99");
	}

	@And("^User clicks on Login button$")
	public void User_clicks_on_Login_button() throws InterruptedException {
		System.out.println("User_clicks_on_Login_button");
		//WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		WebElement loginBtn = driver.findElement(By.xpath("//label[@id='loginbutton']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);
		Thread.sleep(5000);
	}

	@Then("^User navigates to tiles page$")
	public void User_navigates_to_tiles_page() {
		System.out.println("User_navigates_to_tiles_page");
		//String userName = driver.findElement(By.xpath("//div[@class='menu-name ng-binding']")).getText();
		String userName = driver.findElement(By.xpath("//span[@class='_1vp5']")).getText();
		System.out.println("Tiles Page title ::" + userName);
		Assert.assertEquals("Himanshu", userName);
	}

	@Then("^Close the browser$")
	public void Close_the_browser() {
		System.out.println("Close_the_browser");
		driver.quit();

	}
}
