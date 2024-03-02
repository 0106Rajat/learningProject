package practiceproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestCase12 {
	
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
	
	@Ignore("ignore this funtion")
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
	
	
	@Test(priority = 3, dependsOnMethods= {"productPage"})
	public void clickAddCart() throws InterruptedException
	{
		Thread.sleep(5000);
		//dismiss-button
	//String txt = driver.getId()
		
	/*	if(txt = "") {
			WebElement popClose = driver.findElement(By.xpath("//*[@id=\"dismiss-button\"]"));
			popClose.click();
		}*/
	//	driver.switchTo().alert().dismiss();
		//Thread.sleep(5000);
	//	
		//Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,500)", "");
	    Thread.sleep(5000);	
		WebElement addcart = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]/a"));
		addcart.click();
	}	
	
	@Test(priority = 4, dependsOnMethods= {"clickAddCart"})
	public void clickShopingBtn() throws InterruptedException
	{
		Thread.sleep(10000);
		WebElement shopingbtn = driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button"));
		shopingbtn.click();
	}
	
	@Test(priority = 5, dependsOnMethods= {"clickShopingBtn"})
	public void clickAddOtherCart() throws InterruptedException
	{
		Thread.sleep(10000);
		WebElement ele = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]"));

		//Creating object of an Actions class
		Actions action = new Actions(driver);
		//Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
	    Thread.sleep(5000);                     
		WebElement addcart1 = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a"));
		addcart1.click();						
	}
	
	@Test(priority = 6, dependsOnMethods= {"clickAddOtherCart"})
	public void viewCart() throws InterruptedException
	{
		Thread.sleep(5000);                    
		WebElement viewcart = driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u"));
		viewcart.click();
	}
	
	@Test(priority = 7, dependsOnMethods= {"viewCart"})
	public void countProduct() throws InterruptedException
	{
		Thread.sleep(10000);
		String porduct1 = "Blue Top";
		String porduct2 = "Men Tshirt";                   
		WebElement proname1 = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[2]/h4/a"));
		WebElement proname2 = driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[2]/h4/a"));
		String porductname1 = proname1.getText();
		String porductname2 = proname2.getText();
		Assert.assertEquals(porductname1, porduct1);
		Assert.assertEquals(porductname2, porduct2);
	}
	
	@Test(priority = 8, dependsOnMethods= {"countProduct"})
	public void verifyProduct() throws InterruptedException
	{
		Thread.sleep(10000);
		String heading1 = "Price";
		String heading2 = "Quantity";
		String heading3 = "Total";
		WebElement colName1 = driver.findElement(By.cssSelector("#cart_info_table > thead > tr > td.price"));
		WebElement colName2 = driver.findElement(By.cssSelector("#cart_info_table > thead > tr > td.quantity"));
		WebElement colName3 = driver.findElement(By.cssSelector("#cart_info_table > thead > tr > td.total"));
		String title1 = colName1.getText();
		String title2 = colName2.getText();
		String title3 = colName3.getText();
		Assert.assertEquals(heading1, title1);
		Assert.assertEquals(heading2, title2);
		Assert.assertEquals(heading3, title3);
	}
	
}
