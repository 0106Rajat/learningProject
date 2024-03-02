package testcase;

public class Testsel {
	
	/*
	24. launch different browsers
	WebDriver driver = new FirefoxDriver();
	
	25. use of driver.get(“URL”) and driver.navigate().to(“URL”) commands, any difference
	driver.navigate() allows moving back and forward in browser history with the help of driver.navigate().forward() and
	driver.navigate().back() commands.
	driver.navigate().to() navigates to a particular section by changing the URL without refreshing the page.
	driver.get() refreshes the page and history is not maintained.

	26. How can we type text in a textbox element using Selenium?
	sendKeys() method
	
	27. How can we clear a text written in a textbox?
	can use the clear() method
	
	28. How to check a checkbox in Selenium?
	The same click() method that we use for clicking buttons or radio buttons can be used for checking the checkbox as well.
	
	29. How can we submit a form in Selenium?
	Using the submit() method we can submit a form in selenium.

	driver.findElement(By.id("form1")).submit();
	Also, we can use the click() method for the same purpose.
	
	30. Explain the difference between close and quit commands.
	The difference between close and quit commands is-
	driver.close() – Used to close the current browser having a focus.
	driver.quit() – Used to close all the browser instances.
	
	31. How to switch between multiple windows in Selenium?
	Selenium has driver.getWindowHandles() and driver.switchTo().window(“{windowHandleName}”) commands to work with multiple windows.
	The getWindowHandles() command returns a list of ids corresponding to each window.
	If we pass a particular window handle to the driver.switchTo().window(“{windowHandleName}”) command then we can switch control/focus to that particular window.

	for (String windowHandle : driver.getWindowHandles()) {
     driver.switchTo().window(handle);
	}
	
	32. What is the difference between driver.getWindowHandle() and driver.getWindowHandles() in Selenium?
	The driver.getWindowHandle() returns a handle of the current window (a single unique identifier).
	Whereas driver.getWindowHandles() returns a set of handles of all the windows available.
	
	33. How can we move to a particular frame in Selenium?
	The driver.switchTo() command is used for switching to a particular iframe.

	driver.switchTo().frame("{frameIndex/frameId/frameName}");
	For locating a frame, we can either use the index (starting from 0), its name, or its Id.

	34. Can we move back and forward in the browser using Selenium?
	Yes, using driver.navigate().back() and driver.navigate().forward() commands, we can move backward and forward in a browser.

	35. What are the different ways to refresh a browser?
	There a multiple ways to refresh a page in Selenium-
	
	Using driver.navigate().refresh() command.
	Using sendKeys(Keys.F5) on any textbox on the webpage.
	By using driver.get(“URL”) on the current URL or using driver.getCurrentUrl().
	Using driver.navigate().to(“URL”) on the current URL or driver.navigate().to(driver.getCurrentUrl());
	
	36. How can we maximize the browser window in Selenium?
	driver.manage().window().maximize();
	
	37. How can we fetch a text written over an element?
	Using the getText() method we can fetch the text over an element.
	String text = driver.findElement("elementLocator").getText();

	38. How can we find the value of different attributes like name, class, and value of an element?
	Using getAttribute(“{attributeName}”) method, we can find the value of different attributes of an element.

	String valueAttribute =	driver.findElement(By.id("locator")).getAttribute("value");
	
	39. How to delete cookies in Selenium?
	Using deleteAllCookies() method.
	driver.manage().deleteAllCookies();
	
	40. What is an implicit wait in Selenium?
	
	An implicit wait is a type of wait that waits for a specified time while locating an element before 
	throwing NoSuchElementException. By default, Selenium tries to find web elements immediately when 
	required without any wait. So, it is good to use implicit wait. This wait is applied to all the 
	elements of the current driver instance.
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	41. What is an explicit wait in Selenium?
	An explicit wait is a type of wait that is applied to a particular web element until the expected condition specified is met.
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("elementId")));
	It is advisable to use explicit waits over implicit waits because a higher timeout value of implicit wait (set for handling only some of the slow elements) gets applied to all the web elements. Thus increasing the overall execution time of the script. On the other hand, we can apply different timeouts to the different elements in case of explicit waits.
	
	Check our detailed tutorial here – Implicit & Explicit Waits in Selenium.
	
	42. What are some expected conditions in Explicit waits?
	Some of the commonly used expected conditions of an element in explicit waits are-
	
	elementToBeClickable(WebElement element or By locator)
	stalenessOf(WebElement element)
	visibilityOf(WebElement element)
	visibilityOfElementLocated(By locator)
	invisibilityOfElementLocated(By locator)
	attributeContains(WebElement element, String attribute, String value)
	alertIsPresent()
	titleContains(String title)
	titleIs(String title)
	textToBePresentInElementLocated(By, String)
	
	43. What is a fluent wait?
	A fluent wait is a type of wait in which we can also specify the polling intervals (the time intervals after which the driver will try to find the elements when not located) along with the maximum timeout value.
	
	FluentWait - Selenium interview question
	Wait wait = new FluentWait(driver)
	 
	    .withTimeout(20, SECONDS)
	 
	    .pollingEvery(5, SECONDS)
	 
	    .ignoring(NoSuchElementException.class);
	 
	  WebElement textBox = wait.until(new Function<webdriver,webElement>() {
	 
	    public WebElement apply(WebDriver driver) {
	 
	    return driver.findElement(By.id("textBoxId"));
	 
	    }
	}
	);
	
	44. What are the different keyboard operations that can be performed in Selenium?
	The different keyboard operations that can be performed in Selenium are-
	
	.sendKeys(“sequence of characters”) – Used for passing character sequence to an input or textbox 
		element.
	.pressKey(“non-text keys”) – Used for keys like control, function keys etc that are non-text.
	.releaseKey(“non-text keys”) – Used in conjunction with the keypress event to simulate releasing a 
		key from the keyboard event.
			
	45. What are the different mouse actions that can be performed using Selenium?
	The different mouse events supported in Selenium are-
	
	click(WebElement element)
	doubleClick(WebElement element)
	contextClick(WebElement element)
	mouseDown(WebElement element)
	mouseUp(WebElement element)
	mouseMove(WebElement element)
	mouseMove(WebElement element, long xOffset, long yOffset)	
	
	46. Write the code to double-click an element.
	Code to double-click an element-
	
	Actions action = new Actions(driver);
	WebElement element=driver.findElement(By.id("elementId"));
	action.doubleClick(element).perform();
		
	47. Write the code to right-click an element.
	Code to right-click an element in selenium-
	
	Actions action = new Actions(driver);
	WebElement element=driver.findElement(By.id("elementId"));
	action.contextClick(element).perform();
	
	48. How to mouse hover an element in Selenium?
	Code to mouse hover over an element-
	
	Actions action = new Actions(driver);
	WebElement element=driver.findElement(By.id("elementId"));
	action.moveToElement(element).perform();

	49. How to fetch the current page URL in Selenium?
	In order to fetch the current page URL, we can use the getCurrentURL() command.
	
	driver.getCurrentUrl();
	
	50. How can we fetch the title of the page in Selenium?
	Using driver.getTitle() command, we can fetch the page title in Selenium. This method returns a string containing the title of the webpage.
		
	51. How can we fetch the page source in Selenium?
	Using the driver.getPageSource() command, we can fetch the page source in selenium. 
	This method returns a string containing the page source.
		
	
	53. How to locate a link using its text in Selenium?
	Using linkText() and partialLinkText() methods, we can locate a link. The difference between the two is – linkText() matches the complete string passed as a parameter to the link texts. Whereas partialLinkText() only matches the string parameter partially.
	
	WebElement link1 = driver.findElement(By.linkText("artOfTesting"));
	WebElement link2 = driver.findElement(By.partialLinkText("artOf"));
	
	54. What are DesiredCapabilities in Selenium WebDriver?
	Desired capabilities are a set of key-value pairs that are used for storing or configuring browser-specific
	properties. For example – the browser’s version, platform, etc in the browser instances.
	
	Read more: Desiredcapabilities in Selenium
	
	55. How can we find all the links on a web page?
	All the links are of anchor tag ‘a’. So by locating elements of tagName ‘a’ we can find all the links on a webpage.
	
	List<WebElement> links = driver.findElements(By.tagName("a"));
	
	
	56. What are some commonly encountered exceptions in Selenium?
	Some of the commonly seen exceptions in Selenium are-
	
	NoSuchElementException – When no element can be located by the locator provided.
	ElementNotVisibleException – When an element is present in the DOM but is not visible.
	NoAlertPresentException – When we try to switch to an alert box but the targetted alert is not present.
	NoSuchFrameException – When we try to switch to a frame but the targetted frame is not present.
	NoSuchWindowException – When we try to switch to a window but the targetted window is not present.
	UnexpectedAlertPresentException – When an unexpected alert blocks the normal interaction of the driver.
	TimeoutException – When a command execution gets a timeout.
	InvalidElementStateException – When the state of an element is not appropriate for the desired action.
	NoSuchAttributeException – When we are trying to fetch an attribute’s value but the attribute is not correct.
	WebDriverException – When there is some issue with the driver instance preventing it from getting launched.
	
	58. How to handle dropdowns in Selenium?
	Using Select class-
	
	Select countriesDropDown = new Select(driver.findElement(By.id("countries")));
	dropdown.selectByVisibleText("India");
	//or using index of the option starting from 0
	dropdown.selectByIndex(1);
	//or using its value attribute
	dropdown.selectByValue("Ind");
	
	62. What is the difference between driver.findElement() and driver.findElements() commands?
	The difference between driver.findElement() and driver.findElements() commands are-
	
	findElement() returns a single WebElement (found first) based on the locator passed as a parameter. Whereas findElements() returns a list of WebElements, all satisfying the locator value passed.
	
	Syntax of findElement()-
	WebElement textbox = driver.findElement(By.id(“textBoxLocator”));
	
	Whereas the syntax of findElements()-
	List <WebElement> elements = driver.findElements(By.id(“value”));
	
	Another difference between the two is – if no element is found then findElement() throws NoSuchElementException whereas findElements() returns a list of 0 elements.
	Selenium interview questions and answers
	
	63. How can we handle window UI elements and window POP-ups using selenium?
	Selenium is used for automating web-based applications only(or browsers only). If we want to handle window GUI elements then we can use tools like AutoIT.
	
	AutoIT is a freeware used for automating Windows GUI. The AutoIt scripts follow the simple BASIC language-like syntax. Also, it can be easily integrated with Selenium tests.
	
	
	//pending 31, 38, 57,	
		
	52. How to verify tooltip text using Selenium?
	Tooltips web elements have an attribute of type ‘title’. 
	By fetching the value of the ‘title’ attribute, we can verify the tooltip text in selenium.
	
	String toolTipText = element.getAttribute("title");
	
	
	57. How can we capture screenshots using Selenium?
	In order to take screenshots in Selenium, we can use the getScreenshotAs method of the TakesScreenshot interface.
	
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrFile, new File("D:\\testScreenShot.jpg"));
	
	
	59. How to check which option in the dropdown is selected?
	Using is Selected() method, we can check the state of a dropdown’s option.
	
	Select countriesDropDown = new Select(driver.findElement(By.id("countries")));
	dropdown.selectByVisibleText("India");
	System.out.println(driver.findElement(By.id("India")).isSelected());
		
		
	60. How can we check if an element is getting displayed on a web page?
	Using the isDisplayed() method we can check if an element is getting displayed on a web page.
	
	driver.findElement(By locator).isDisplayed();
	
	61. How can we check if an element is enabled for interaction on a web page?
	Using the isEnabled method, we can check if an element is enabled or not.
	
	driver.findElement(By locator).isEnabled();
	
	64. What is Robot API?
	Robot API is used for handling Keyboard or mouse events.
	
	Robot robot = new Robot();
	//Simulate enter key action
	robot.keyPress(KeyEvent.VK_ENTER);
	
	65. How to do file upload in Selenium?
	File upload action can be performed in multiple ways-
	
	Using element.sendKeys(“path of file”) on the web element of ‘input’ tag and type ‘file’ i.e. the elements should be like –
	<input type=”file” name=”fileUpload”>
	With the help of Robot API.
	Using the AutoIT API.
	
	
	66. How to handle the HTTPS website in Selenium or how to accept the SSL untrusted connection?
	Using profiles, we can handle accepting the SSL untrusted connection certificate. Profiles are basically a set of user preferences stored in a file.
	
	FirefoxProfile profile = new FirefoxProfile();
	profile.setAcceptUntrustedCertificates(true); 
	profile.setAssumeUntrustedCertificateIssuer(false);
	WebDriver driver = new FirefoxDriver(profile); 
	
	67. How to do drag and drop in Selenium?
	Using the Action class, drag and drop can be performed in Selenium. Sample code-
	
	Actions builder = new Actions(driver);
	Action dragAndDrop = builder.clickAndHold(SourceElement)
	.moveToElement(TargetElement)
	.release(TargetElement)
	.build();
	dragAndDrop.perform();
	
	68. How to execute JavaScript code in Selenium?
	JavaScript code can be executed in Selenium using JavaScriptExecuter. Sample code for javascript execution-
	
	WebDriver driver = new FireFoxDriver();
	if (driver instanceof JavascriptExecutor) {
	 ((JavascriptExecutor)driver).executeScript("{JavaScriptCode}");
	}
	
	69. How to handle alerts in Selenium?
	In order to accept or dismiss an alert box, the alert class is used. This requires first switching to the alert box and then using accept() or dismiss() command as the case may be.
	
	Alert alert = driver.switchTo().alert(); 
	//To accept the alert
	alert.accept();
	Alert alert = driver.switchTo().alert(); 
	//To cancel the alert box
	alert.dismiss();
	
	70. What is HtmlUnitDriver?
	HtmlUnitDriver is the fastest WebDriver. Unlike other drivers (FireFoxDriver, ChromeDriver, etc), the HtmlUnitDriver is non-GUI. On executing test scripts, no browser gets visible.
	
	
	
	71. How to handle hidden elements in Selenium WebDriver?
	Using JavaScript executor we can handle hidden elements-
	
	(JavascriptExecutor(driver))
	 .executeScript("document.getElementsByClassName(locator).click();");
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
































	*/
}
