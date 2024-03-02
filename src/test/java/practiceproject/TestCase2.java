package practiceproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestCase2 {
	
	// Login User with correct email and password
	
	WebDriver driver = new ChromeDriver();
	String baseurl = "https://automationexercise.com/";
	
	@BeforeTest
	public void openBrowse() 
	{
		driver.manage().window().maximize();
		driver.get(baseurl);
		System.out.println("Login User with correct email and password");
	}
	
	@Test(priority = 1)
	public void loginBTN() throws InterruptedException
	{
		Thread.sleep(15000);
		WebElement signup = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
		signup.click();
	}
	
	@Test(priority = 2)
	public void loginPageVerify() throws InterruptedException
	{
		Thread.sleep(10000);
		String curUrl = driver.getCurrentUrl();
		String actualTitle = driver.getTitle() ;
		String expectedTitle= "Automation Exercise - Signup / Login";
		System.out.println("Actual Title is:"+ actualTitle);
		System.out.println("Expected Title is:"+ expectedTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority = 3)
	public void loginUser() throws InterruptedException 
	{
		Thread.sleep(10000);
		WebElement useremail = driver.findElement(By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=email]:nth-child(2)"));
		useremail.sendKeys("rajat123@yopmail.com");
		WebElement userpass = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]"));
		userpass.sendKeys("Pass@1234");
		WebElement login_now = driver.findElement(By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > button"));
		login_now.click();
	}
	
	@Test(priority = 4)
	public void afterLoginPageVerify() throws InterruptedException
	{
		Thread.sleep(10000);
		String actualTitle1 = driver.getTitle() ;
		String expectedTitle1 = "Automation Exercise";
		
		if(actualTitle1 == expectedTitle1) {
			System.out.println("Real page open");
		}else {
			System.out.println("Wrong page open");
		}
	}

}
