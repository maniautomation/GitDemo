package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Forgotpassword;
import pageObjects.LandingPage;
import pageObjects.loginPage;
import resource.base; 
 
public class HomePage extends base { 
	
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(validateTitle.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{

		driver = initializeDriver();  
		
	} 
	
	
	@Test(dataProvider = "getdata")
public void basepagenavigation(String mail,String password,String text) throws IOException

{ 

	driver.get(prop.getProperty("url"));   
	  
	LandingPage lp = new LandingPage(driver); 
		 
	if(lp.getpopupsize().size()>0)
	{
		lp.popup().click();
	}
	
	loginPage lop = lp.getlogin();     
		
	lop.getemail().sendKeys(mail);
	
	lop.getpassword().sendKeys(password);
	
	lop.getlogin().click();
	
	Forgotpassword fp =lop.forgotpassword();
	
	fp.getmail().sendKeys("mani");
	 
	fp.sendinstructions().click();
	
	 log.info(text);
	 
 System.out.println("welcome to github");
	 
 System.out.println("welcome to Hub");
 
 System.out.println("welcome to Hub1");

 System.out.println("welcome to Hub2");

 System.out.println("welcome to Hub3");

 System.out.println("welcome to Hub4");


		 
}
	@DataProvider 
	public Object[][] getdata()
	
	{ 
		//row stands for how many different types test should run
		//coloumn stands for how many values per each test
		
		Object[][] data = new Object[2][3];
		
		//0th row
		data[0][0]="nonrestricted@gmail.com";
		data[0][1]="123456";
		data[0][2]="nonrestricted"; 
		
		//1st row
		
	    data[1][0]="restricted@gmail.com";
		data[1][1]="123456";
		data[1][2]="restricted"; 
				
		return data;
	}
	
	@AfterTest
	public void Teardown()
	{
		driver.close();
	}
	
	

}
