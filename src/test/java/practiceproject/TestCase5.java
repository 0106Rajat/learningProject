package practiceproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestCase5 {

	//Register User with existing email
	
	WebDriver driver = new ChromeDriver();
	String baseurl = "https://automationexercise.com/";
	
	@BeforeTest
	public void openBrowse() 
	{
		driver.manage().window().maximize();
		driver.get(baseurl);
		System.out.println("Register User with existing email");
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
	
	@Test(priority = 11)
	public void registerUserExistEmail()  throws InterruptedException
	{
		Thread.sleep(10000);
		WebElement name = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
		name.sendKeys("Rajat");
		WebElement email = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
		email.sendKeys("rajatqa111@yopmail.com");
		WebElement signupuser = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
		signupuser.click();
	}
}
