package practiceproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestCase6 {
	
	// Contact Us Form
	
	WebDriver driver = new ChromeDriver();
	String baseurl = "https://automationexercise.com/";
	
	@BeforeTest
	public void openBrowse() 
	{
		driver.manage().window().maximize();
		driver.get(baseurl);
		System.out.println("Contact Us Form");
	}
	
	@Ignore("Current Page Verify function not use now")
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
	public void contactUS() throws InterruptedException
	{
		Thread.sleep(15000);
		WebElement contactus = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a/i"));
		contactus.click();
	}
	
	@Test(priority = 3)
	public void contactPageVerify() throws InterruptedException
	{
		Thread.sleep(10000);
		String actualTitle2 = driver.getTitle();
		String expectedTitle2 = "Automation Exercise - Contact Us";
		System.out.println("expectedTitle is: " + expectedTitle2);
		System.out.println("actualTitle is: " + actualTitle2);
		Assert.assertEquals(actualTitle2, expectedTitle2);
	}
	
	@Test(priority = 4)
	public void contactusDetails() throws InterruptedException
	{
		Thread.sleep(10000);
	//	driver.switchTo().alert().dismiss();
		WebElement name = driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input"));
		name.sendKeys("Ajay");
		WebElement email = driver.findElement(By.cssSelector("#contact-us-form > div:nth-child(3) > input"));
		email.sendKeys("rajat12@mailinator.com");
		WebElement subject = driver.findElement(By.cssSelector("#contact-us-form > div:nth-child(4) > input"));
		subject.sendKeys("New Information Now");
		WebElement message = driver.findElement(By.id("message"));
		message.sendKeys("Developing FE models for bony segments is easier to achieve than developing soft-tissue models, because model geometries for bones are much easier to obtain.");
		//Thread.sleep(1000);
		WebElement testfile = driver.findElement(By.xpath("//input[@name='upload_file']"));
		Thread.sleep(5000);
		testfile.click();
		//testfile.sendKeys("C:\\Users\\Clavis10\\Downloads\\logo.png"); 
		WebElement submitnow = driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input"));
		submitnow.click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	}
	
	@Test(priority = 5)
	public void successMessage() throws InterruptedException
	{
		Thread.sleep(5000);
		String expectedTest = "Success! Your details have been submitted successfully.";
		WebElement mess = driver.findElement(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]"));
		String findtest = mess.getText();
		System.out.println("actualTitle is: " + expectedTest);
		System.out.println("actualTitle is: " + findtest);
		Assert.assertEquals(expectedTest, findtest);
	}
	
	@Test(priority = 6)
	public void clickHomeBtn() throws InterruptedException
	{
		Thread.sleep(5000);
		WebElement btnH = driver.findElement(By.cssSelector("#form-section > a"));
		btnH.click();
	}
	
	@Test(priority = 7)
	public void landHomePageVerify() throws InterruptedException
	{
	Thread.sleep(10000);
	String actualTitle = driver.getTitle() ;
	String expectedTitle= "Automation Exercise";
	System.out.println("Actual Title is:"+ actualTitle);
	System.out.println("Expected Title is:"+ expectedTitle);
	Assert.assertEquals(actualTitle, expectedTitle);
	}
	
}
