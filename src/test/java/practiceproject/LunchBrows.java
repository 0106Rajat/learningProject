package practiceproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class LunchBrows {

	WebDriver driver = new ChromeDriver();
	String baseurl = "https://automationexercise.com/";
	//String url1 = driver.getCurrentUrl();
	
	@BeforeTest
	public void openBrowse() 
	{
		driver.manage().window().maximize();
		driver.get(baseurl);
	}
}