package practiceproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PageVerify{
	
	WebDriver driver = new ChromeDriver();
	String baseurl = "https://automationexercise.com/";
	
	@BeforeTest
	public void openBrowse() 
	{
		driver.manage().window().maximize();
		driver.get(baseurl);
	}
	
	@Test(priority = 1)
	public void titleTest() 
	{
		String cutUrl=driver.getCurrentUrl();
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Automation Exercise";
		driver.get(cutUrl);
		System.out.println("URL is:" + cutUrl);
		System.out.println("Actual Title is:" + ActualTitle);
		System.out.println("Expected Title is:" + ExpectedTitle);
		Assert.assertEquals(ExpectedTitle, ActualTitle);	
	}	
	
}
