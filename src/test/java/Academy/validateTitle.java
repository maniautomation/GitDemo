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
 
public class validateTitle extends base {
	
	public WebDriver driver;

	LandingPage lp;
	
	public static Logger log = LogManager.getLogger(validateTitle.class.getName());

	
	@BeforeTest
	public void initialize() throws IOException
	{

		driver = initializeDriver(); 
		
		log.info(" Driver is initiliazed");
		
       driver.get(prop.getProperty("url"));  
       
		log.info("Navigated to homepage");
		
		System.out.println("valiadate title");
		
		System.out.println("valiadate title2");


	} 
	 
	@Test
	public void validatepagetitle() throws IOException
	{

		
	 lp = new LandingPage(driver);
		
		System.out.println(lp.gettiltle().getText());
		
		Assert.assertEquals(lp.gettiltle().getText(), "FEATURED COURSES");
		
		log.info(" Succesfully validated Text message");
		
	}
	@Test
	public void getHeader() throws IOException
	{
		 lp = new LandingPage(driver);

		
		System.out.println(lp.getheader().getText());

		Assert.assertEquals(lp.getheader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");  
		
				 
	}

	@AfterTest
	public void Teardown()
	{
		driver.close(); 
	}
}
