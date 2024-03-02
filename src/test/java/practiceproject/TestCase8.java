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

public class TestCase8 {
	
	// Verify All Products and product detail page
	
	WebDriver driver = new ChromeDriver();
	String baseurl = "https://automationexercise.com/";
	
	@BeforeTest
	public void openBrowse() 
	{
		driver.manage().window().maximize();
		driver.get(baseurl);
		System.out.println("Verify All Products and product detail page");
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
	public void productPage() throws InterruptedException
	{
		Thread.sleep(10000);
		WebElement productp = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a"));
		productp.click();
	}
	
	@Test(priority = 3)
	public void productPageVerify() throws InterruptedException
	{
		Thread.sleep(10000);
		String actualTitlepp = driver.getTitle();
		String expectedTitlepp = "Automation Exercise - All Products";
		System.out.println("expectedTitle is: " + expectedTitlepp);
		System.out.println("actualTitle is: " + actualTitlepp);
		Assert.assertEquals(actualTitlepp, expectedTitlepp);
	}
	
	@Test(priority = 4)
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
	
	@Test(priority = 5)
	public void productClick() throws InterruptedException
	{
		Thread.sleep(10000);
		WebElement productclick = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a"));
		productclick.click();
	}
	
	@Test(priority = 6)
	public void viewProductPage() throws InterruptedException
	{
		Thread.sleep(10000);
		WebElement pname = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2"));
		String productName = pname.getText();
		WebElement pcategory = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]"));
		String productCategory = pcategory.getText();
		WebElement pprice = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span"));
		String productPrice= pprice.getText();
		WebElement pavailability = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]"));
		String productAvailability= pavailability.getText();
		WebElement pcondition = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]"));
		String productCondition= pcondition.getText();
		WebElement pbrand = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]"));
		String productBrand= pbrand.getText();
		System.out.println("Product Name is: " + productName);
		System.out.println("Product Category is: " + productCategory);
		System.out.println("Product Price is: " + productPrice);
		System.out.println("Product Availability is: " + productAvailability);
		System.out.println("Product Condition is: " + productCondition);
		System.out.println("Product Brand is: " + productBrand);
	}
	
}
