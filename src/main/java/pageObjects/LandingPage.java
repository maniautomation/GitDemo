package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	
	public WebDriver driver;
	 
public LandingPage(WebDriver driver)  
{
    this.driver=driver;
}


private By signin =	By.cssSelector("a[href*='sign_in'");

public loginPage getlogin() 
   { 
	    driver.findElement(signin).click();
	    
		loginPage lop = new loginPage(driver);
		
		return lop;  

   }
 


private By alert =By.xpath("//button[contains(text(),'NO THANKS')]");
	
public List<WebElement> getpopupsize()
{
	return driver.findElements(alert);

}

public WebElement popup() 
{  
	
	
	return driver.findElement(alert);

} 


private By title =By.xpath("//h2[contains(text(),'Featured Courses')]"); 
	
public WebElement gettiltle()
{
	return driver.findElement(title);
}
 


private By navigationbar = By.xpath("//header/div[2]/div[1]/nav[1]");

public WebElement getnavigationbar()   
{
	return driver.findElement(navigationbar);
	
}

private By header = By.cssSelector("div[class*='video-banner'] h3");

public WebElement getheader()  
{
	return driver.findElement(header);
	
} 

}

