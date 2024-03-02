package practiceproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestCase10 {
		
	// Verify Subscription in home page
	
	WebDriver driver = new ChromeDriver();
	String baseurl = "https://automationexercise.com/";
	
	@BeforeTest
	public void openBrowse() 
	{
		driver.manage().window().maximize();
		driver.get(baseurl);
		System.out.println("Verify Subscription in home page");
	}	
	
	@Test(priority = 1)
	public void nowVerify() throws InterruptedException
	{
		Thread.sleep(10000);
		String actualTitle3 = driver.getTitle();
		String expectedTitle3 = "Automation Exercise";
		System.out.println("expectedTitle is: " + expectedTitle3);
		System.out.println("actualTitle is: " + actualTitle3);
		Assert.assertEquals(actualTitle3, expectedTitle3);
	}
	
	@Test(priority = 2)
	public void subscriptionHome() throws InterruptedException
	{
		Thread.sleep(15000);
		WebElement substest = driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2"));
		String subText = substest.getText();
		String expectedText = "SUBSCRIPTION";
		System.out.println(" Subscription text is: " + subText);
		System.out.println("Expected text is: " + expectedText);
		Assert.assertEquals(expectedText, subText);
	}
		
}
