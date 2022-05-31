package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;


public class base { 
	
	public WebDriver driver; 
	public Properties prop;

	
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		
		//System.getProperty("user.dir");
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resource\\Data.properties");
		
		prop.load(fis); 
		 
		
 	  // String browserName = System.getProperty("browser");

	    String browserName = prop.getProperty("browser"); 
	    //System.out.println(browserName);
		
		if(browserName.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32 (2)\\chromedriver.exe");  

			/*ChromeOptions options = new ChromeOptions();
			
			if(browserName.contains("headless"))
			{
				
			options.addArguments("headless"); 
			
			} */
			
	         driver = new ChromeDriver();		 

		}
		else if (browserName.equals("firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.30.0-win64\\geckodriver.exe");  
			
	         driver = new FirefoxDriver();
			 

		}
		else if (browserName.equals("IE"))
		{

			System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer_x64_4.0.0\\IEDriverServer.exe");  
			
	        driver = new InternetExplorerDriver();

		} 
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
		
	}
	
	public String getscreenshotpath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot  ts = (TakesScreenshot)driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destinationfile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		
		FileUtils.copyFile(source, new File(destinationfile) );
		
		return destinationfile;  
		
	} 
	

}