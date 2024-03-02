package testcase;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class BrowserTest {
	
	WebDriver driver;
	String baseurl = "https://www.w3schools.com/php/default.asp";
	
	
	//Always Run
	
	@BeforeTest()
	public void login() {
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		//driver.get("https://dev.zyratalk.com/");
		driver.manage().window().maximize();
		
	//	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//WebElement signinLinktext = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[2]/li[2]/a"));
		//signinLinktext.click();
		//driver.findElement(By.xpath("//*[@id=\"login_email_id\"]")).sendKeys("rajatdev11@mailinator.com");
		//driver.findElement(By.xpath("//*[@id=\"login_password_id\"]")).sendKeys("Pass@1234");
		//WebElement signinBtn = driver.findElement(By.xpath("//*[@id=\"sign-in-form\"]/div[3]/button"));
		//signinBtn.click();		
	}
	
	@Test
	public void allLinks() throws InterruptedException{
		Thread.sleep(5000);
		driver.get(baseurl);
		Thread.sleep(15000);
		int links = driver.findElements(By.tagName("a")).size();
		System.out.println(links);
	//	String total[] = links.length();
		
		
		//for(int i=1; i<=links.length(); i++) {
		//	System.out.println("total[]");
		//}
		//System.out.println("total[]");
	}
	
	
	@Ignore("link and partiallink action case is not required")
	@Test
	public void linkandpartiallink() throws InterruptedException{
		Thread.sleep(5000);
		driver.get(baseurl);
		Thread.sleep(15000);
		//driver.findElement(By.linkText("PHP HOME")).click();
		driver.findElement(By.partialLinkText("Intro")).click();
		
	}
	
	@Ignore("mouse action case is not required")
	@Test
	public void rgtClick() throws InterruptedException {
		Thread.sleep(15000);
		driver.get(baseurl);
		Thread.sleep(15000);
		Actions actionhere = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"text\"]"));
		actionhere.contextClick(element).perform();
	}
	
	@Ignore("fetch text case is not required")
	@Test
	public void fetchTest() throws InterruptedException {
		Thread.sleep(15000);
		driver.getCurrentUrl();
		Thread.sleep(10000);
		WebElement demo = driver.findElement(By.xpath("//h2"));
		String ss = demo.getText();
		System.out.println(ss);	
	}
	
	@Ignore("Page source cookkies case is not required")
	@Test
	public void source() throws InterruptedException {
		Thread.sleep(10000);
		driver.getCurrentUrl();
		Thread.sleep(10000);
		String sp = driver.getPageSource();
		System.out.println(sp);
	}
	
	@Ignore("Wait cookkies case is not required")
	@Test
	public void waitTest() {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	@Ignore("delete cookkies case is not required")
	@Test
	public void delCookies() {
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().deleteAllCookies();
	}
	
	@Ignore("current URL case is not required")
	@Test
	public void fetchData() {
		String cutUrl=driver.getCurrentUrl();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(cutUrl);
	}
	
	@Ignore("refresh page case is not required")
	@Test
	public void refreshPage() throws InterruptedException {
		Thread.sleep(15000);
		driver.get("https://devreact.zyratalk.com/chat-setup");
		Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(10000);
		driver.getCurrentUrl();
	}

	@Ignore("Switch Window case is not required")
	@Test
	public void changeSwitchNow() throws InterruptedException {
		Thread.sleep(10000);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://devreact.zyratalk.com/chat-setup");
		Thread.sleep(10000);
	}
	
	@Ignore("Window Handler case is not required")
	@Test
	public void handleWindowNow() throws InterruptedException {
		Thread.sleep(10000);
		driver.get("https://devreact.zyratalk.com/chat-setup");
		String winvalue = driver.getWindowHandle();
		Thread.sleep(10000);
		driver.switchTo().window("winvalue");	
	}
	
	@Ignore("Radio and Checkbox case is not required")
	@Test
	public void checkTask() throws InterruptedException {
		Thread.sleep(10000);
		driver.navigate().to("https://devreact.zyratalk.com/chat-setup");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"customizeFormId\"]/div/div[2]/div[6]/div[1]/label[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"customizeFormId\"]/div/div[2]/div[7]")).click();
	}
	
	@Ignore("Test Input and clean test case is not required")
	@Test
	public void textData() throws InterruptedException {
		Thread.sleep(10000);
		driver.get("https://devreact.zyratalk.com/completed-chats");
		Thread.sleep(10000);
		driver.findElement(By.id("generalSearch")).sendKeys("test");
		Thread.sleep(5000);
		driver.findElement(By.id("generalSearch")).clear();
	}
	
	@Ignore("Get URL test case is not required")
	@Test
	public void directUrl() throws InterruptedException {
		Thread.sleep(10000);
		//driver.get("https://devreact.zyratalk.com/completed-chats");
		driver.navigate().to("https://devreact.zyratalk.com/chat-setup");
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().forward();
	}
	
	@Ignore("dropdown test case is not required")
	@Test(priority = 1)
	public void selectTest() throws InterruptedException {
		Thread.sleep(10000);
		WebElement drpdwnTest = driver.findElement(By.xpath("//*[@id=\"kt_form_type\"]/option[4]"));
		drpdwnTest.click();
	}
	
	@Ignore("Export test case is not required")
	@Test(priority = 2)
	public void csvDload() throws InterruptedException {
		Thread.sleep(10000);
		WebElement exportBtn = driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div/div/div/div[1]/div/div/div/div/div[3]/div/button"));
		exportBtn.click();
	}
	
	@Ignore("menu test case is not required")
	@Test(priority = 3)
	public void haderMenu() throws InterruptedException {
		Thread.sleep(10000);
		WebElement liveChatTab = driver.findElement(By.xpath("//*[@id=\"kt_header_menu\"]/ul/li[2]"));
		liveChatTab.click();
		Thread.sleep(10000);
		WebElement yourChatTab = driver.findElement(By.xpath("//*[@id=\"kt_header_menu\"]/ul/li[3]"));
		yourChatTab.click();
		Thread.sleep(10000);
		WebElement chatSetupTab = driver.findElement(By.xpath("//*[@id=\"kt_header_menu\"]/ul/li[4]"));
		chatSetupTab.click();
		Thread.sleep(10000);
		WebElement workSpaceTab = driver.findElement(By.xpath("//*[@id=\"kt_header_menu\"]/ul/li[5]"));
		workSpaceTab.click();
		Thread.sleep(10000);
		WebElement installTab = driver.findElement(By.xpath("//*[@id=\"kt_header_menu\"]/ul/li[6]"));
		installTab.click();
	}
	
	@Ignore("Sidebar test case is not required")
	@Test(priority = 4)
	public void sidebarMenu() throws InterruptedException {
		Thread.sleep(15000);
		WebElement sidebarToggleBtn = driver.findElement(By.xpath("//*[@id=\"kt_header\"]/div/div[1]/span[1]/i"));
		sidebarToggleBtn.click();
		Thread.sleep(10000);
		WebElement reviewMenu = driver.findElement(By.xpath("//*[@id=\"kt_aside_menu\"]/ul/li[2]/a"));
		reviewMenu.click();
		Thread.sleep(10000);
		WebElement engageMenu = driver.findElement(By.xpath("//*[@id=\"kt_aside_menu\"]/ul/li[3]/a"));
		engageMenu.click();
		Thread.sleep(10000);
		WebElement settingMenu = driver.findElement(By.xpath("//*[@id=\"kt_aside_menu\"]/ul/li[4]/a"));
		settingMenu.click();
		Thread.sleep(10000);
		WebElement conversationMneu = driver.findElement(By.xpath("//*[@id=\"kt_aside_menu\"]/ul/li[1]/a"));
		conversationMneu.click();
	}
	
	@Ignore("Forget Password test case is not required")
	@Test
	public void forgetPass() throws InterruptedException {
		Thread.sleep(10000);
		WebElement signinLinktext = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[2]/li[2]/a"));
		signinLinktext.click();
		Thread.sleep(10000);
		WebElement LinktextforgotPassword = driver.findElement(By.xpath("//*[@id=\"forgotPassword\"]"));
		LinktextforgotPassword.click();
		driver.findElement(By.id("forgor_email_id")).sendKeys("danish@yopmail.com");
		driver.findElement(By.xpath("//*[@id=\"forgotPanel\"]/button")).click();
	}
	
	//Always Run
	@Ignore("Logout test case is not required")
	@Test
	public void userLogout() throws InterruptedException {
		Thread.sleep(10000);
		WebElement LogoutUser = driver.findElement(By.xpath("//*[@id=\"kt_header\"]/div/div[3]/div[2]"));
		LogoutUser.click();
		Thread.sleep(5000);
		WebElement SignOutUser = driver.findElement(By.xpath("//*[@id=\"kt_header\"]/div/div[3]/div[2]/div[2]/div[2]/div/a"));
		SignOutUser.click();
	}
	
	@AfterTest
  	public void tearDown() throws InterruptedException{
		//driver.close();
		Thread.sleep(5000);
		driver.quit();
  	}
		
	public static void main(String[] args) throws InterruptedException 
	{
		BrowserTest ln = new BrowserTest();
		ln.login();	
	//	BrowserTest selTest = new BrowserTest();
	//	selTest.selectTest();
	//	BrowserTest lout = new BrowserTest();
	//	lout.userLogout();
	//	BrowserTest pass = new BrowserTest();
	//	pass.forgetPass();
	}
}
