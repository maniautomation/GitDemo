package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Forgotpassword {

	public Forgotpassword(WebDriver driver) 
	{
		this.driver=driver;
	}

	public WebDriver driver;

	private By email = By.cssSelector("[id = 'user_email']");
	
	public WebElement getmail() 
	{
		return driver.findElement(email);
	}
	
	private By sendmeInstructions = By.cssSelector("[type='submit']");
	
	public WebElement sendinstructions()
	{
		return driver.findElement(sendmeInstructions);
	}

}
