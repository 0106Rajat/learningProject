package practiceproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestCase13 {
	
	// Add Products in Cart
	
	WebDriver driver = new ChromeDriver();
	String baseurl = "https://automationexercise.com/";
	
	@BeforeTest
	public void openBrowse() 
	{
		driver.manage().window().maximize();
		driver.get(baseurl);
		System.out.println("Add Products in Cart");
	}
	
	@Test(priority = 1)
	public void clickView() throws InterruptedException
	{
		Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 700)", "");
		Thread.sleep(5000);
		WebElement viewDetails = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[2]/div/div[2]/ul/li/a"));
		viewDetails.click();
	}
	
	@Test(priority = 2, dependsOnMethods = {"clickView"})
	public void verifyViewPage() throws InterruptedException
	{
		Thread.sleep(10000);
		String expectedTitle = "Automation Exercise - Product Details";
		String actualTitle = driver.getTitle();
		System.out.println("Expected Title is:" + expectedTitle);
		System.out.println("Actual Title is:" + actualTitle);
		Assert.assertEquals(expectedTitle, actualTitle);
		
	}
		
	@Test(priority = 3, dependsOnMethods = {"verifyViewPage"})
	public void addQuantity() throws InterruptedException
	{
		Thread.sleep(10000);
		Actions action = new Actions(driver);
		WebElement viewDetails = driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
		viewDetails.sendKeys(Keys.CONTROL + "a");
		viewDetails.sendKeys(Keys.DELETE);
		Thread.sleep(5000);
		//action.keyUp(Keys.SHIFT).build().perform();
		action.keyDown(Keys.SHIFT).sendKeys(viewDetails,"1").keyUp(Keys.SHIFT).perform();
		//action.keyDown(Keys.SHIFT).sendKeys("1").keyUp(Keys.SHIFT).build().perform();
		   
		//viewDetails.click();
		//System.out.println("product quantity increase successfully");
	/*	WebElement resetvalue = driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
		resetvalue.sendKeys(Keys.CONTROL + "a");
		resetvalue.sendKeys(Keys.DELETE);
		Thread.sleep(5000);
		WebElement viewDetails = driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
		viewDetails.sendKeys("4");*/
		/*int a=4; 
		for(int n=1; n<=a ; n++) {
			WebElement viewDetails = driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
			viewDetails.click();
		}
		System.out.println("product quantity increase successfully");*/
	}
}
