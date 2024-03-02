package practiceproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import junit.framework.Assert;

public class TestCase1{
	
	// Register User
	
	WebDriver driver = new ChromeDriver();
	String baseurl = "https://automationexercise.com/";
	
	@BeforeTest
	public void openBrowse() 
	{
		//launch Browser
		driver.manage().window().maximize();
		driver.get(baseurl);
		System.out.println("Register User");
	}

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
	public void loginBTN() throws InterruptedException
	{
		Thread.sleep(15000);
		WebElement signup = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
		signup.click();
	}
	
	@Test(priority = 3)
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
	
	@Test(priority = 4)
	public void registerUser()  throws InterruptedException
	{
		Thread.sleep(10000);
		WebElement name = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
		name.sendKeys("Rajat");
		WebElement email = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
		email.sendKeys("rajat123@yopmail.com");
		WebElement signupuser = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
		signupuser.click();
	}
	
	@Test(priority = 5)
	public void createAccount() throws InterruptedException 
	{
		Thread.sleep(10000);
		WebElement title = driver.findElement(By.id("id_gender1"));
		title.click();
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys("Pass@1234");
		WebElement dobday = driver.findElement(By.xpath("//*[@id=\"days\"]"));
		dobday.sendKeys("4");
		WebElement dobmonth = driver.findElement(By.xpath("//*[@id=\"months\"]"));
		dobmonth.sendKeys("May");
		WebElement dobyear = driver.findElement(By.xpath("//*[@id=\"years\"]"));
		dobyear.sendKeys("1999");
		//WebElement newsletters = driver.findElement(By.cssSelector("#newsletter"));
		//newsletters.click();		
		WebElement fname = driver.findElement(By.cssSelector("#first_name"));
		fname.sendKeys("Rajat");
		WebElement lname = driver.findElement(By.id("last_name"));
		lname.sendKeys("Kumar");
		WebElement company = driver.findElement(By.id("company"));
		company.sendKeys("TEST");
		WebElement address1 = driver.findElement(By.id("address1"));
		address1.sendKeys("noida");
		WebElement countryname = driver.findElement(By.xpath("//*[@id=\"country\"]"));  
		countryname.sendKeys("Canada");
		WebElement statename = driver.findElement(By.xpath("//*[@id=\"state\"]"));
		statename.sendKeys("British Columbia");
		WebElement cityname = driver.findElement(By.cssSelector("#city"));
		cityname.sendKeys("Alkali Lake");
		WebElement areacode = driver.findElement(By.xpath("//*[@id=\"zipcode\"]"));
		areacode.sendKeys("250");
		WebElement contact = driver.findElement(By.id("mobile_number"));
		contact.sendKeys("1234567890");
		WebElement createacc = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button"));
		createacc.click(); 
	}
	
	@Test(priority = 6)
	public void clickBTN() throws InterruptedException 
	{
		Thread.sleep(10000);
		WebElement clickbtn = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
		clickbtn.click();
	}
	
	@Ignore("delete function not use now")
	@Test(priority = 7)
	public void deleteUser1() throws InterruptedException 
	{
		Thread.sleep(10000);
		WebElement deleteUser1 = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
		deleteUser1.click();
	}
	
	@Ignore("delete User function not use now")
	@Test(priority = 8)
	public void deleteUser2() throws InterruptedException 
	{
		Thread.sleep(10000);
		WebElement deleteUser2 = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
		deleteUser2.click();
	}	

}
