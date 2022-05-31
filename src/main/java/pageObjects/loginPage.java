package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	public WebDriver driver;
	
	public loginPage(WebDriver driver)
	{
		this.driver = driver;
	}
 
	
	private By email = By.cssSelector("[id = 'user_email']");
	public WebElement getemail()
	{
		return driver.findElement(email);
	} 
	
	 
	private By password  = By.cssSelector("[type ='password']"); 

	public WebElement getpassword() 
	{
		return driver.findElement(password);
	}
	
	
	private By login = By.cssSelector("[type ='submit']"); 
    public WebElement getlogin() 
	{
		return driver.findElement(login); 
	}
    
    
    private By forgotpassword = By.xpath("//a[contains(text(),'Forgot Password?')]");
    public Forgotpassword forgotpassword()
    {
    	driver.findElement(forgotpassword).click();
    	
    	return new Forgotpassword(driver);
    	
    }

}
