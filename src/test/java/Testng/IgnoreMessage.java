package Testng;

public class IgnoreMessage {
	
	private String message;


	//constructor
	//@param message to be printed
	public IgnoreMessage(String message1) {
		this.message = message1;
	}
	
	public String printMessage() {
		System.out.println(message);
		return message;
	}
	
	public String subMessage() {
		message = "Hi" + message;
		System.out.println(message);
		return message;
	}

}
