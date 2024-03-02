package practiceproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestCase11 {
	
	// Verify Subscription in cart page
	
		WebDriver driver = new ChromeDriver();
		String baseurl = "https://automationexercise.com/";
		
		@BeforeTest
		public void openBrowse() 
		{
			driver.manage().window().maximize();
			driver.get(baseurl);
			System.out.println("Verify Subscription in cart page");
		}	
		
		@Test(priority = 1)
		public void nowVerify() throws InterruptedException
		{
			Thread.sleep(10000);
			String actualTitle = driver.getTitle();
			String expectedTitle = "Automation Exercise";
			System.out.println("expectedTitle is: " + expectedTitle);
			System.out.println("actualTitle is: " + actualTitle);
			Assert.assertEquals(actualTitle, expectedTitle);
		}
		
		@Test(priority = 2)
		public void clickCartPAge() throws InterruptedException {
			Thread.sleep(10000);
			WebElement clickcart = driver.findElement(By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(3) > a"));
			clickcart.click();                                      
		}
		
		@Test(priority = 3)
		public void subscriptionCart() throws InterruptedException
		{
			Thread.sleep(10000);
			WebElement substest = driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div/div[1]/div[2]/div/h2"));
			String subText = substest.getText();
			String expectedText = "SUBSCRIPTION";
			System.out.println(" Subscription text is: " + subText);
			System.out.println("Expected text is: " + expectedText);
			Assert.assertEquals(expectedText, subText);
		}
		
}
