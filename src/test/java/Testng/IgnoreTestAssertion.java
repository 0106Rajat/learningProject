package Testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IgnoreTestAssertion {
	
	String message = "Rajat";
	IgnoreMessage imsg = new IgnoreMessage(message);
	
	@Test(enabled = false)
	public void testPrintMessage() {
		System.out.println("testPrintMessage");
		message = "Rajat";
		Assert.assertEquals(message, imsg.printMessage());
	}
	
	@Test
	public void testSubMessage() {
		System.out.println("testSubMessage here");
		message = "Hi" + "Rajat";
		Assert.assertEquals(message, imsg.subMessage());
		}
	}