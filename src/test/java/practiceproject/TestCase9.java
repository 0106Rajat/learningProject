package practiceproject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestCase9 {
	
	// Search Product
	
	WebDriver driver = new ChromeDriver();
	String baseurl = "https://automationexercise.com/";
	
	@BeforeTest
	public void openBrowse() 
	{
		driver.manage().window().maximize();
		driver.get(baseurl);
		System.out.println("Search Product");
	}
	
	@Test(priority = 1)
	public void productPage() throws InterruptedException
	{
		Thread.sleep(10000);
		WebElement productp = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a"));
		productp.click();
	}
	
	@Ignore("Product Page Verify function not use now")
	@Test(priority = 2)
	public void productPageVerify() throws InterruptedException
	{
		Thread.sleep(10000);
		String actualTitlepp = driver.getTitle();
		String expectedTitlepp = "Automation Exercise - All Products";
		System.out.println("expectedTitle is: " + expectedTitlepp);
		System.out.println("actualTitle is: " + actualTitlepp);
		Assert.assertEquals(actualTitlepp, expectedTitlepp);
	}
	
	@Test(priority = 3)
	public void productListVerify() throws InterruptedException
	{
		Thread.sleep(10000);
		WebElement productListTitle = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/h2"));
		String listTitle = productListTitle.getText();
		String expectedListTitle = "ALL PRODUCTS";
		System.out.println("Expected List Title is: " + expectedListTitle);
		System.out.println("Actual Title is: " + listTitle);
		Assert.assertEquals(expectedListTitle, listTitle);
	}
	
	@Test(priority = 4)
	public void productSearch() throws InterruptedException
	{
		Thread.sleep(10000);
		
		WebElement searchTest = driver.findElement(By.id("search_product"));
		searchTest.sendKeys("Dress");
		Thread.sleep(10000);
		WebElement clickSearchBtn = driver.findElement(By.id("submit_search"));
		clickSearchBtn.click();
		List<WebElement> searchdresslist = new ArrayList();
		
	}
	
}
