package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resource.base;

public class Navigationpage extends base { 
	
	public WebDriver driver;

	
	public static Logger log = LogManager.getLogger(validateTitle.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{

		driver = initializeDriver(); 
		
       driver.get(prop.getProperty("url"));   
       System.out.println("navigation page");
	}
	
   @Test
	public void navigationbar() throws IOException 
	{ 

	   LandingPage lp = new LandingPage(driver);
		
	   Assert.assertTrue(lp.getnavigationbar().isDisplayed()); 
	   
		log.info("Navigation bar is displayed");

		
	}
   
   @AfterTest
   public void teardown()
   {
	   
	   driver.close();
   }
}
